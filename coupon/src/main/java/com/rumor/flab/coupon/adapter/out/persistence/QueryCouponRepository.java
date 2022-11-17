package com.rumor.flab.coupon.adapter.out.persistence;

import com.rumor.flab.coupon.adapter.in.web.ResponseCoupon;

import java.util.List;

public interface QueryCouponRepository {
    List<CouponEntity> findAll();
}
