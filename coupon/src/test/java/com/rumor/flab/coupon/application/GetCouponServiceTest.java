package com.rumor.flab.coupon.application;

import com.rumor.flab.coupon.domain.Coupon;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GetCouponServiceTest {

    @Autowired
    GetCouponService getCouponService;

    @Test
    public void getCoupons() {
        List<Coupon> coupons = getCouponService.getCoupons();
        System.out.println("coupons = " + coupons);
    }

}