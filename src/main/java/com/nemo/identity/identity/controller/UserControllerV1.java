package com.nemo.identity.identity.controller;

import com.nemo.identity.identity.exception.BadLoginException;
import com.nemo.identity.identity.model.User;
import com.nemo.identity.identity.payload.JWTokenResponse;
import com.nemo.identity.identity.payload.ResponsePayload;
import com.nemo.identity.identity.payload.TokenValidationResponse;
import com.nemo.identity.identity.repository.UserRepository;
import com.nemo.identity.identity.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/v1")
public class UserControllerV1 {
    @Autowired
    private UserRepository userRepostiry;

    @Autowired
    private LoginService loginService;

    @PostMapping("/signup")
    public User signup(@Valid @RequestBody User user) {
        user.setPassword(loginService.hashPassword(user.getPassword()));
        return userRepostiry.save(user);
    }

    @PostMapping("/login")
    public ResponseEntity login(@Valid @RequestBody User login) {
        User user = userRepostiry.findUserByEmail(login.getEmail());
        if (!loginService.isPasswordValid(login.getPassword(), user.getPassword()))
            throw new BadLoginException();
        String token = loginService.getJWToken(user.getUuid());

        return ResponseEntity
                .ok()
                .header("content-type", "application/json")
                .body((new ResponsePayload(new JWTokenResponse(token, user.getEmail()))).getJsonPayload());
    }

    @GetMapping("/token/{token}")
    public ResponseEntity validateToken(@PathVariable("token") String token) {
        return ResponseEntity
                .ok()
                .header("content-type", "application/json")
                .body((new ResponsePayload(loginService.validateToken(token))).getJsonPayload());
    }


}
