package com.rumor.flab.coupon.adapter.out.persistence;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Getter
@Table(name = "coupon")
public class CouponEntity {

        @Id
        @GeneratedValue
        private Long id;
        private Long owner;
        private String name;
        private String image;
        private LocalDate created;
        private LocalDate updated;
}
