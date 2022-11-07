package com.rumor.flab.coupon.application.port.out;

import com.rumor.flab.coupon.domain.Coupon;

import java.util.List;

public interface LoadCouponPort {
    List<Coupon> findAll();
}
