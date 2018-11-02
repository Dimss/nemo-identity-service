package com.nemo.identity.identity.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LoginService {


    public String hashPassword(String clearTextPassword) {
        return BCrypt.hashpw(clearTextPassword, BCrypt.gensalt(12));
    }

    public Boolean isPasswordValid(String clearTextPassword, String passHash) {
        return BCrypt.checkpw(clearTextPassword, passHash);
    }

    public String getJWToken(String email) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            return JWT.create()
                    .withIssuer("identity")
                    .withSubject(email)
                    .withExpiresAt(new Date((new Date().getTime()) + 10000l * 60 * 60))
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw exception;
        }
    }

}
