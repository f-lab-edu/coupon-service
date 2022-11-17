package com.rumor.flab.coupon.application;

import com.rumor.flab.coupon.adapter.in.web.RequestCoupon;
import com.rumor.flab.coupon.application.factory.CouponRegister;
import com.rumor.flab.coupon.application.factory.CouponRegisterFactory;
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
    public Coupon registerCoupon(RequestCoupon requestCoupon) {
        CouponRegister couponRegister = CouponRegisterFactory.create(requestCoupon.getGenerationType());
        Coupon coupon = couponRegister.register(requestCoupon);
        return registerCouponPort.registerCoupon(coupon);
    }
}
