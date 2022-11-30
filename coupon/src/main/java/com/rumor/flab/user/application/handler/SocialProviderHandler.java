package com.rumor.flab.user.application.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rumor.flab.user.application.dto.SocialUser;

public interface SocialProviderHandler {
    SocialUser oauthLogin(String code);
}
