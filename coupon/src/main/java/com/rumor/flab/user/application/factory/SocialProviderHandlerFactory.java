package com.rumor.flab.user.application.factory;

import com.rumor.flab.user.application.enums.SocialType;
import com.rumor.flab.user.application.handler.AppleOauthHandler;
import com.rumor.flab.user.application.handler.FaceBookOauthHandler;
import com.rumor.flab.user.application.handler.GoogleOauthHandler;
import com.rumor.flab.user.application.handler.SocialProviderHandler;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SocialProviderHandlerFactory {
    private final Map<SocialType, SocialProviderHandler> socialHandlerMap = new HashMap<>();

    private GoogleOauthHandler googleOauthHandler;
    private FaceBookOauthHandler faceBookOauthHandler;
    private AppleOauthHandler appleOauthHandler;

    public SocialProviderHandlerFactory(GoogleOauthHandler googleOauthHandler, FaceBookOauthHandler faceBookOauthHandler, AppleOauthHandler appleOauthHandler) {
        socialHandlerMap.put(SocialType.GOOGLE, googleOauthHandler);
        socialHandlerMap.put(SocialType.FACEBOOK, faceBookOauthHandler);
        socialHandlerMap.put(SocialType.APPLE, appleOauthHandler);
    }

    public SocialProviderHandler findHandler(SocialType socialType) {
        return socialHandlerMap.get(socialType);
    }
}
