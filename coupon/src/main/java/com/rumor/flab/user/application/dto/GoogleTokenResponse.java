package com.rumor.flab.user.application.dto;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GoogleTokenResponse {
    private String accessToken;
    private String expiresIn;
    private String refreshToken;
    private String scope;
    private String tokenType;
    private String idToken;

    public GoogleTokenResponse(String accessToken, String expiresIn, String refreshToken, String scope, String tokenType, String idToken) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.refreshToken = refreshToken;
        this.scope = scope;
        this.tokenType = tokenType;
        this.idToken = idToken;
    }
}
