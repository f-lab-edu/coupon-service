package com.rumor.flab.user.adapter.out.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rumor.flab.user.application.port.out.RegisterUserPort;
import com.rumor.flab.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CommandUserRepository implements RegisterUserPort {

    private final ObjectMapper objectMapper;
    private final UserSpringDataJpaRepository userSpringDataJpaRepository;

    @Override
    public User registerUser(User user) {
        UserEntity userEntity = objectMapper.convertValue(user, UserEntity.class);

        if (userEntity != null) {
            return objectMapper.convertValue(userSpringDataJpaRepository.save(userEntity), User.class);
        }

        return null;
    }
}