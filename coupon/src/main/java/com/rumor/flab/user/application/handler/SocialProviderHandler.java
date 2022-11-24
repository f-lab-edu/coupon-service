package com.rumor.flab.user.application.handler;

import com.rumor.flab.user.domain.SocialUser;

public interface SocialProviderHandler {
    SocialUser oauthLogin(String credential);
}
