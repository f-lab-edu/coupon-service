package com.rumor.flab.user.application.handler;

import com.rumor.flab.UserDomainTestConfig;
import com.rumor.flab.user.application.dto.SocialUser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = UserDomainTestConfig.class)
class GoogleOauthHandlerTest {

    @Autowired
    GoogleOauthHandler googleOauthHandler;

    @Test
    @DisplayName("토큰값을 마음대로 넣는 경우 에러 발생")
    void verify() {
        Assertions.assertThatThrownBy(() -> {
            SocialUser socialUser = ReflectionTestUtils.invokeMethod(googleOauthHandler, "verify", "fsaekljfkasjk");
        }).isInstanceOf(IllegalArgumentException.class);

    }
}