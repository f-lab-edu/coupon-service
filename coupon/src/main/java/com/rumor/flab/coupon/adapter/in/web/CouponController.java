package com.rumor.flab.coupon.adapter.in.web;

import com.rumor.flab.coupon.application.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class CouponController {

    private final CouponService couponService;

    @GetMapping("/coupons")
    public String coupons() {
        couponService.getCoupons();
        return "coupon";
    }
}
