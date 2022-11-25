package com.rumor.flab.user.application.port.in;

import com.rumor.flab.user.application.enums.SocialType;
import com.rumor.flab.user.domain.User;

public interface SocialLoginUserCase {
    User login(SocialType socialType, String code);
}
