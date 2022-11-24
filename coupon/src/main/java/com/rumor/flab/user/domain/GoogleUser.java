package com.rumor.flab.user.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
public class GoogleUser implements SocialUser {
    private final String userId;
    private final String email;
}
