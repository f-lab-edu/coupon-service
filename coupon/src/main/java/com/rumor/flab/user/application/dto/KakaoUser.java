package com.rumor.flab.user.application.dto;

public class KakaoUser implements SocialUser {
    private final String userId;
    private final String email;
    private final String locale;

    public KakaoUser(String userId, String email, String locale) {
        this.userId = userId;
        this.email = email;
        this.locale = locale;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getUserId() {
        return this.userId;
    }

    @Override
    public String getLocale() {
        return null;
    }
}
