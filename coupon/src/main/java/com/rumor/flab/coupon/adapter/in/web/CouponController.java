package com.rumor.flab.coupon.adapter.in.web;

import com.rumor.flab.coupon.adapter.out.persistence.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CouponController {

    private final CouponRepository couponRepository;

    @GetMapping("/coupons")
    public ResponseCoupons coupons() {
        List<ResponseCoupon> coupons = couponRepository.findAll();
        return new ResponseCoupons(coupons);
    }
}
