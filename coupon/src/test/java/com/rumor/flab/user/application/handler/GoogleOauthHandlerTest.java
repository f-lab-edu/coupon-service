package com.rumor.flab.user.application.handler;

import com.rumor.flab.user.application.dto.SocialUser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

@SpringBootTest
class GoogleOauthHandlerTest {

    @Autowired
    GoogleOauthHandler googleOauthHandler;

    @Test
    @DisplayName("토큰값을 마음대로 넣는 경우 에러 발생")
    void verify() {
        Assertions.assertThatThrownBy(() -> {
            SocialUser socialUser = ReflectionTestUtils.invokeMethod(googleOauthHandler, "verify", "fsaekljfkasjk");
        }).isInstanceOf(IllegalStateException.class);

    }
}