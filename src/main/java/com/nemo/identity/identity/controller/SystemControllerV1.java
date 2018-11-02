package com.nemo.identity.identity.controller;

import com.nemo.identity.identity.payload.AppStatusResponse;
import com.nemo.identity.identity.payload.ResponsePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/system")
public class SystemControllerV1 {

    @Autowired
    private Environment environment;

    @Autowired
    BuildProperties buildProperties;

    @GetMapping("/info")
    public ResponseEntity status() {
        return ResponseEntity
                .ok()
                .header("content-type", "application/json")
                .body((new ResponsePayload(new AppStatusResponse(buildProperties)).getJsonPayload()));
    }


}
