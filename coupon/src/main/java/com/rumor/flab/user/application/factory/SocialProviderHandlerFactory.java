package com.rumor.flab.user.application.factory;

import com.rumor.flab.user.application.enums.SocialType;
import com.rumor.flab.user.application.handler.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SocialProviderHandlerFactory {
    private final Map<SocialType, SocialProviderHandler> socialHandlerMap = new HashMap<>();

    private GoogleOauthHandler googleOauthHandler;
    private FaceBookOauthHandler faceBookOauthHandler;
    private AppleOauthHandler appleOauthHandler;
    private KakaoOauthHandler kakaoOauthHandler;

    public SocialProviderHandlerFactory(GoogleOauthHandler googleOauthHandler,
                                        FaceBookOauthHandler faceBookOauthHandler,
                                        AppleOauthHandler appleOauthHandler,
                                        KakaoOauthHandler kakaoOauthHandler) {
        this.googleOauthHandler = googleOauthHandler;
        this.faceBookOauthHandler = faceBookOauthHandler;
        this.appleOauthHandler = appleOauthHandler;
        this.kakaoOauthHandler = kakaoOauthHandler;
        mappingHandler();
    }

    private void mappingHandler() {
        socialHandlerMap.put(SocialType.GOOGLE, googleOauthHandler);
        socialHandlerMap.put(SocialType.FACEBOOK, faceBookOauthHandler);
        socialHandlerMap.put(SocialType.APPLE, appleOauthHandler);
        socialHandlerMap.put(SocialType.KAKAO, kakaoOauthHandler);
    }

    public SocialProviderHandler findHandler(SocialType socialType) {
        return socialHandlerMap.get(socialType);
    }
}
