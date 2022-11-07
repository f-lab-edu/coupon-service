package com.rumor.flab.coupon.application;

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
    private GetCouponService getCouponService;

    @Test
    void registerCoupon() {
        Coupon coupon = new Coupon(1L, 1L, "커피쿠폰", "", null, null);
        registerCouponService.registerCoupon(coupon);

        List<Coupon> coupons = getCouponService.getCoupons();
        Assertions.assertThat(coupons.contains(coupon)).isTrue();
    }
}