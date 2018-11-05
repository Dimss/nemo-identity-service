package com.nemo.identity.identity.payload;

import org.springframework.boot.info.BuildProperties;

import java.time.Instant;

public class TokenValidationResponse {

    private Boolean valid;
    private String message;

    public TokenValidationResponse(Boolean valid, String message) {
        this.valid = valid;
        this.message = message;
    }


}
