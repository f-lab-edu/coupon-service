package com.rumor.flab.coupon.adapter.in.web;

import com.rumor.flab.coupon.application.GetCouponService;
import com.rumor.flab.coupon.application.RegisterCouponService;
import com.rumor.flab.coupon.domain.Coupon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CouponController {

    private final GetCouponService getCouponService;
    private final RegisterCouponService registerCouponService;

    @GetMapping("/coupons")
    public String coupons() {
        getCouponService.getCoupons();
        return "coupon";
    }

    @PostMapping("/coupon")
    public String registerCoupon(Coupon coupon) {
        registerCouponService.registerCoupon(coupon);
        return "create";
    }
}
