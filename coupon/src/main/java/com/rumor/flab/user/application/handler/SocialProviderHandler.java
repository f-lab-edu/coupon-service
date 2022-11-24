package com.rumor.flab.user.application.handler;

import com.rumor.flab.user.domain.SocialUser;
import org.springframework.stereotype.Component;

public interface SocialProviderHandler {
    SocialUser oauthLogin();
}
