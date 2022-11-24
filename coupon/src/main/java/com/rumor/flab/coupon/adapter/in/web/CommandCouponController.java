package com.rumor.flab.coupon.adapter.in.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rumor.flab.coupon.application.RegisterCouponService;
import com.rumor.flab.coupon.domain.Coupon;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommandCouponController {
    private final RegisterCouponService registerCouponService;

    private final ObjectMapper objectMapper;

    @PostMapping("/coupon")
    public ResponseCoupon registerCoupon(RequestCoupon coupon) {
        Coupon registeredCoupon = registerCouponService.registerCoupon(coupon);
        ResponseCoupon responseCoupon = objectMapper.convertValue(registeredCoupon, ResponseCoupon.class);
        return responseCoupon;
    }
}

