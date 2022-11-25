package com.rumor.flab.user.adapter.out.persistence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSpringDataJpaRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
}
