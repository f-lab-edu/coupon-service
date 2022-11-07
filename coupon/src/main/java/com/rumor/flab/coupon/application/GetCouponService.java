package com.rumor.flab.coupon.application;

import com.rumor.flab.coupon.adapter.out.persistence.CouponEntity;
import com.rumor.flab.coupon.application.port.in.GetCouponUserCase;
import com.rumor.flab.coupon.application.port.in.RegisterCouponUseCase;
import com.rumor.flab.coupon.application.port.out.LoadCouponPort;
import com.rumor.flab.coupon.domain.Coupon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetCouponService implements GetCouponUserCase {

    private final LoadCouponPort loadCouponPort;

    @Override
    public List<Coupon> getCoupons() {
        return loadCouponPort.findAll();
    }
}
