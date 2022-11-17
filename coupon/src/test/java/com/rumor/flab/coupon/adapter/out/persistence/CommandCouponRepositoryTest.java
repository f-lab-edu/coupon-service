package com.rumor.flab.coupon.adapter.out.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rumor.flab.coupon.domain.Coupon;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommandCouponRepositoryTest {

    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    CouponSpringDataJpaRepository couponSpringDataJpaRepository;

    @Test
    public void 저장이_제대로_이루어지는지() {
        Coupon coupon = new Coupon(1L, 1L, "test", "", LocalDate.now(), LocalDate.now());
        CouponEntity couponEntity = objectMapper.convertValue(coupon, CouponEntity.class);
        CouponEntity savedCoupon = couponSpringDataJpaRepository.save(couponEntity);

        Assertions.assertThat(couponEntity).isEqualTo(savedCoupon);
    }
}