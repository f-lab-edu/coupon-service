package com.rumor.flab.coupon.adapter.out.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rumor.flab.coupon.domain.Coupon;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CouponRepositoryTest {

    @Autowired
    private CouponRepository couponRepository;

    @Autowired
    private CommandCouponRepository commandCouponRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void findAll() {
        Coupon coupon = new Coupon(1L, 1L, "test", "", LocalDate.now(), LocalDate.now());
        Coupon savedCoupon = commandCouponRepository.registerCoupon(coupon);
        List<Coupon> coupons = couponRepository.findAll().stream()
                .map(responseCoupon -> objectMapper.convertValue(responseCoupon, Coupon.class))
                .collect(Collectors.toList());
        Assertions.assertThat(coupons.contains(savedCoupon)).isTrue();
    }
}