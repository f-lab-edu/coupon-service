package com.rumor.flab.coupon.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rumor.flab.coupon.adapter.in.web.ResponseCoupon;
import com.rumor.flab.coupon.adapter.out.persistence.CouponEntity;
import com.rumor.flab.coupon.adapter.out.persistence.CouponRepository;
import com.rumor.flab.coupon.domain.Coupon;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RegisterCouponServiceTest {

    @Autowired
    private RegisterCouponService registerCouponService;
    @Autowired
    private CouponRepository couponRepository;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void registerCoupon() {
        Coupon coupon = new Coupon(1L, 1L, "커피쿠폰", "", null, null);
        registerCouponService.registerCoupon(coupon);

        List<CouponEntity> coupons = couponRepository.findAll();
        CouponEntity responseCoupon = objectMapper.convertValue(coupon, CouponEntity.class);
        Assertions.assertThat(coupons.contains(responseCoupon)).isTrue();
    }
}