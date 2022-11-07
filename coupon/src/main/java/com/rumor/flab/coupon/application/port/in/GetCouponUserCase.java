package com.rumor.flab.coupon.application.port.in;

import com.rumor.flab.coupon.domain.Coupon;

import java.util.List;

public interface GetCouponUserCase {
    List<Coupon> getCoupons();
}
