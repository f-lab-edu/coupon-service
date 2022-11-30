package com.rumor.flab.user.application.port.out;

import com.rumor.flab.user.domain.User;

public interface RegisterUserPort {
    User registerUser(User user);
}
