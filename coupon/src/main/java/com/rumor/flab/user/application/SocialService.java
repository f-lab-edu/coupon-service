package com.rumor.flab.user.application;

import com.rumor.flab.user.application.dto.SocialUser;
import com.rumor.flab.user.application.enums.SocialType;
import com.rumor.flab.user.application.factory.SocialProviderHandlerFactory;
import com.rumor.flab.user.application.handler.SocialProviderHandler;
import com.rumor.flab.user.application.port.in.SocialLoginUserCase;
import com.rumor.flab.user.application.port.out.FindUserPort;
import com.rumor.flab.user.application.port.out.RegisterUserPort;
import com.rumor.flab.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SocialService implements SocialLoginUserCase {

    private final RegisterUserPort registerUserPort;
    private final FindUserPort findUserPort;
    private final SocialProviderHandlerFactory socialProviderHandlerFactory;

    @Override
    public User login(SocialType socialType, String code) {
        SocialProviderHandler handler = socialProviderHandlerFactory.findHandler(socialType);
        SocialUser socialUser = handler.oauthLogin(code);

        User foundUser = findUserPort.findByEmail(socialUser.getEmail());

        if (foundUser == null) {
            User user = new User(socialUser.getEmail(), "", "");
            registerUserPort.registerUser(user);
            return user;
        }

        return foundUser;
    }

}
