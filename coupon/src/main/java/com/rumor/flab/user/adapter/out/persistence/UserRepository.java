package com.rumor.flab.user.adapter.out.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rumor.flab.user.application.port.out.FindUserPort;
import com.rumor.flab.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository implements FindUserPort {

    private final ObjectMapper objectMapper;
    private final UserSpringDataJpaRepository userSpringDataJpaRepository;

    @Override
    public Optional<User> findByEmail(String email) {
        Optional<UserEntity> userEntity = userSpringDataJpaRepository.findByEmail(email);
        return Optional.ofNullable(objectMapper.convertValue(userEntity.get(), User.class));

    }
}
