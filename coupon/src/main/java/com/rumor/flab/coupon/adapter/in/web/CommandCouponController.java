package com.rumor.flab.coupon.adapter.in.web;

import com.rumor.flab.coupon.application.RegisterCouponService;
import com.rumor.flab.coupon.domain.Coupon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CommandCouponController {
    private final RegisterCouponService registerCouponService;

    @PostMapping("/coupon")
    public String registerCoupon(RequestCoupon coupon) {
        registerCouponService.registerCoupon(coupon);
        return "create";
    }
}
