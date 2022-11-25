package com.rumor.flab.user.application.dto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GoogleUser implements SocialUser {
    private final String userId;
    private final String email;

    @Override
    public String getEmail() {
        return null;
    }
}
