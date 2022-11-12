package com.rumor.flab.coupon.adapter.out.persistence;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rumor.flab.coupon.application.port.out.RegisterCouponPort;
import com.rumor.flab.coupon.domain.Coupon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommandCouponRepository implements RegisterCouponPort {

    private final CouponSpringDataJpaRepository couponSpringDataJpaRepository;
    private final ObjectMapper objectMapper;

    @Override
    public Coupon registerCoupon(Coupon coupon) {
        CouponEntity couponEntity = objectMapper.convertValue(coupon, CouponEntity.class);
        CouponEntity savedCoupon = couponSpringDataJpaRepository.save(couponEntity);
        return objectMapper.convertValue(savedCoupon, Coupon.class);
    }
}
