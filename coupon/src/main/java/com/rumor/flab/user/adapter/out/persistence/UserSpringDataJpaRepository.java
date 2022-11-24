package com.rumor.flab.user.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSpringDataJpaRepository extends JpaRepository<UserEntity, Long> {
}
