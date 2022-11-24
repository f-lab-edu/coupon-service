package com.rumor.flab.coupon.application.factory;

import com.rumor.flab.coupon.adapter.in.web.RequestCoupon;
import com.rumor.flab.coupon.domain.Coupon;

public interface CouponRegister {
    Coupon register(RequestCoupon requestCoupon);
}
