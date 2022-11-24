package com.rumor.flab.user.application;

import com.rumor.flab.user.application.enums.SocialType;
import com.rumor.flab.user.application.factory.SocialProviderHandlerFactory;
import com.rumor.flab.user.application.handler.SocialProviderHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SocialService {

    private final SocialProviderHandlerFactory socialProviderHandlerFactory;

    public void login(SocialType socialType, String credential) {
        SocialProviderHandler handler = socialProviderHandlerFactory.findHandler(socialType);
        handler.oauthLogin(credential);
    }
}
