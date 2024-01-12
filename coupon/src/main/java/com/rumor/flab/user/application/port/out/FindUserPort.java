package com.rumor.flab.user.application.port.out;

import com.rumor.flab.user.domain.User;

import java.util.Optional;

public interface FindUserPort {
    Optional<User> findByEmail(String email);
}
