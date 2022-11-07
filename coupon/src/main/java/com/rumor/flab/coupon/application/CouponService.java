package com.rumor.flab.coupon.application;

import com.rumor.flab.coupon.application.port.out.LoadCouponPort;
import com.rumor.flab.coupon.domain.Coupon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CouponService {

    private final LoadCouponPort loadCouponPort;

    public List<Coupon> getCoupons() {
        return loadCouponPort.findAll();
    }
}
