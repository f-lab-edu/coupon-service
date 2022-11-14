package com.rumor.flab.coupon.adapter.in.web;

import java.util.List;

public interface QueryCouponRepository {
    List<ResponseCoupon> findAll();
}
