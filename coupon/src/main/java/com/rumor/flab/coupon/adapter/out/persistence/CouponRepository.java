package com.rumor.flab.coupon.adapter.out.persistence;

import com.rumor.flab.coupon.application.port.out.LoadCouponPort;
import com.rumor.flab.coupon.domain.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long>, LoadCouponPort {

}
