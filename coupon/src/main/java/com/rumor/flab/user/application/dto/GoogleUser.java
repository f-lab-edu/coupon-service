package com.rumor.flab.user.application.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GoogleUser implements SocialUser {
    private final String userId;
    private final String email;
    private final String locale;

}
