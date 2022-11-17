package com.rumor.flab.coupon.adapter.out.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rumor.flab.coupon.adapter.in.web.ResponseCoupon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CouponRepository implements QueryCouponRepository {

    private final CouponSpringDataJpaRepository couponSpringDataJpaRepository;

    @Override
    public List<CouponEntity> findAll() {
        return couponSpringDataJpaRepository.findAll();
    }
}
