package com.nemo.identity.identity.payload;

public class JWTokenResponse {
    private String token;
    private String email;
    public JWTokenResponse(String token,String email) {
        this.token = token;
        this.email = email;
    }


}
