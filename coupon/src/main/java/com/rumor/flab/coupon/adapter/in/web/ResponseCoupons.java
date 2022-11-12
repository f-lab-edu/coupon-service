package com.rumor.flab.coupon.adapter.in.web;

import lombok.Getter;

import java.util.List;

@Getter
public class ResponseCoupons {
    private List<ResponseCoupon> coupons;

    public ResponseCoupons(List<ResponseCoupon> coupons) {
        this.coupons = coupons;
    }
}
