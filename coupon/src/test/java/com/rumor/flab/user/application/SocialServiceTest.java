package com.rumor.flab.user.application;

import com.rumor.flab.UserDomainTestConfig;
import com.rumor.flab.user.application.enums.SocialType;
import com.rumor.flab.user.application.factory.SocialProviderHandlerFactory;
import com.rumor.flab.user.application.handler.AppleOauthHandler;
import com.rumor.flab.user.application.handler.FaceBookOauthHandler;
import com.rumor.flab.user.application.handler.GoogleOauthHandler;
import com.rumor.flab.user.application.handler.SocialProviderHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = UserDomainTestConfig.class)
public class SocialServiceTest {

    @Autowired
    SocialProviderHandlerFactory socialProviderHandlerFactory;

    @Test
    public void login() {

    }

    @Test
    @DisplayName("소셜타입에 맞는 객체를 반환하는지?")
    public void findHandler() {
        SocialProviderHandler googleHandler = socialProviderHandlerFactory.findHandler(SocialType.GOOGLE);
        assertThat(googleHandler).isInstanceOf(GoogleOauthHandler.class);

        SocialProviderHandler facebookHandler = socialProviderHandlerFactory.findHandler(SocialType.FACEBOOK);
        assertThat(facebookHandler).isInstanceOf(FaceBookOauthHandler.class);

        SocialProviderHandler appleHandler = socialProviderHandlerFactory.findHandler(SocialType.APPLE);
        assertThat(appleHandler).isInstanceOf(AppleOauthHandler.class);

    }
}