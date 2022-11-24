package com.rumor.flab.coupon.application.port.out;

import com.rumor.flab.coupon.domain.Coupon;

public interface RegisterCouponPort {
    Coupon registerCoupon(Coupon coupon);
}
