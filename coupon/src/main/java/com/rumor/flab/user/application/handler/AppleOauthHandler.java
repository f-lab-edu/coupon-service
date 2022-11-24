package com.rumor.flab.user.application.handler;

import com.rumor.flab.user.domain.SocialUser;
import org.springframework.stereotype.Component;

@Component
public class AppleOauthHandler implements SocialProviderHandler {
    @Override
    public SocialUser oauthLogin() {
        return null;
    }
}
