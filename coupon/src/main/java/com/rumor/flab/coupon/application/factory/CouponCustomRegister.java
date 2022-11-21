package com.rumor.flab.coupon.application.factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rumor.flab.coupon.adapter.in.web.RequestCoupon;
import com.rumor.flab.coupon.domain.Coupon;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CouponCustomRegister implements CouponRegister {

    @Autowired
    private final ObjectMapper objectMapper;

    @Override
    public Coupon register(RequestCoupon requestCoupon) {
        return objectMapper.convertValue(requestCoupon, Coupon.class);

    }
}
