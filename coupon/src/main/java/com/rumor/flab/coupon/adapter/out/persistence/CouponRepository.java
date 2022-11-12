package com.rumor.flab.coupon.adapter.out.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rumor.flab.coupon.application.port.out.RegisterCouponPort;
import com.rumor.flab.coupon.domain.Coupon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CouponRepository {

    private final CouponSpringDataJpaRepository couponSpringDataJpaRepository;
    private final ObjectMapper objectMapper;

    public List<Coupon> findAll() {
        return couponSpringDataJpaRepository.findAll().stream()
                .map(couponEntity -> objectMapper.convertValue(couponEntity, Coupon.class))
                .collect(Collectors.toList());
    }
}
