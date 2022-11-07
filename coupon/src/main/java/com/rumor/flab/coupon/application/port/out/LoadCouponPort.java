package com.rumor.flab.coupon.application.port.out;

import com.rumor.flab.coupon.domain.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LoadCouponPort extends JpaRepository<Coupon, Long> {
}
