package com.rumor.flab.coupon.adapter.out.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rumor.flab.coupon.adapter.in.web.QueryCouponRepository;
import com.rumor.flab.coupon.adapter.in.web.ResponseCoupon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CouponRepository implements QueryCouponRepository {

    private final CouponSpringDataJpaRepository couponSpringDataJpaRepository;
    private final ObjectMapper objectMapper;

    @Override
    public List<ResponseCoupon> findAll() {
        return couponSpringDataJpaRepository.findAll().stream()
                .map(couponEntity -> objectMapper.convertValue(couponEntity, ResponseCoupon.class))
                .collect(Collectors.toList());
    }
}
