package com.rumor.flab.coupon.application;

import com.rumor.flab.coupon.adapter.out.persistence.CouponEntity;
import com.rumor.flab.coupon.application.port.in.RegisterCouponUseCase;
import com.rumor.flab.coupon.application.port.out.RegisterCouponPort;
import com.rumor.flab.coupon.domain.Coupon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterCouponService implements RegisterCouponUseCase {

    private final RegisterCouponPort registerCouponPort;

    @Override
    public Coupon registerCoupon(Coupon coupon) {
        return registerCouponPort.registerCoupon(coupon);
    }
}
