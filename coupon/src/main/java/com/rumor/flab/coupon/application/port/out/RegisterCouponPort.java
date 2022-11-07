package com.rumor.flab.coupon.application.port.out;

import com.rumor.flab.coupon.adapter.out.persistence.CouponEntity;
import com.rumor.flab.coupon.domain.Coupon;

public interface RegisterCouponPort {
    CouponEntity registerCoupon(Coupon coupon);
}
