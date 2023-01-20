package com.com.smart.greenhouse.security;


import com.com.smart.greenhouse.Util.FieldPropertyVisibilityStrategy;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbVisibility;

@JsonbVisibility(FieldPropertyVisibilityStrategy.class)
public class authResponse {

    @JsonbProperty("access_token")
    private String accessToken;

    @JsonbProperty("username")
    private int expiresIn;

    @JsonbProperty("refresh_token")
    private String refreshToken;


    public String getAccessToken() {
        return accessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    static authResponse of(AccessToken accessToken, authRequest.RefreshToken refreshToken, int expiresIn) {
        authResponse response = new authResponse();
        response.accessToken = accessToken.getToken();
        response.refreshToken = refreshToken.getToken();
        response.expiresIn = expiresIn;
        return response;
    }

}