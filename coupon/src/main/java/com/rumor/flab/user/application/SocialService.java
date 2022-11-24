package com.rumor.flab.user.application;

import com.rumor.flab.user.application.dto.SocialUser;
import com.rumor.flab.user.application.enums.SocialType;
import com.rumor.flab.user.application.factory.SocialProviderHandlerFactory;
import com.rumor.flab.user.application.handler.SocialProviderHandler;
import com.rumor.flab.user.application.port.out.RegisterUserPort;
import com.rumor.flab.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SocialService {

    private final RegisterUserPort registerUserPort;
    private final SocialProviderHandlerFactory socialProviderHandlerFactory;

    public void login(SocialType socialType, String credential) {
        SocialProviderHandler handler = socialProviderHandlerFactory.findHandler(socialType);
        SocialUser socialUser = handler.oauthLogin(credential);

        User user = new User(socialUser.getEmail(), "", "");
        registerUserPort.registerUser(user);
    }
}
