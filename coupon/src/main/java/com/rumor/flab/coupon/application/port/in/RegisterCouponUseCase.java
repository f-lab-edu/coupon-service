package com.rumor.flab.coupon.application.port.in;

import com.rumor.flab.coupon.adapter.out.persistence.CouponEntity;
import com.rumor.flab.coupon.domain.Coupon;

public interface RegisterCouponUseCase {
    CouponEntity registerCoupon(Coupon coupon);
}
