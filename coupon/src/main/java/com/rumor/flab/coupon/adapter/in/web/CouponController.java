package com.rumor.flab.coupon.adapter.in.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rumor.flab.coupon.adapter.out.persistence.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class CouponController {

    private final CouponRepository couponRepository;
    private final ObjectMapper objectMapper;

    @GetMapping("/coupons")
    public ResponseCoupons coupons() {
        List<ResponseCoupon> coupons = couponRepository.findAll().stream()
                .map(coupon -> objectMapper.convertValue(coupon, ResponseCoupon.class))
                .collect(Collectors.toList());
        return new ResponseCoupons(coupons);
    }
}
