package com.rumor.flab.coupon.adapter.out.persistence;

import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class CouponBoxEntity {

    @Id @GeneratedValue
    private Long id;
    private Long couponId;
    private Long owner;
    private String name;
    private LocalDate created;
    private LocalDate updated;
}
