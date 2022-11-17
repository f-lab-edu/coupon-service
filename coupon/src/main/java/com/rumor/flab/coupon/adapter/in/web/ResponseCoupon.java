package com.rumor.flab.coupon.adapter.in.web;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class ResponseCoupon {

    private Long id;
    private Long owner;
    private String name;
    private String image;

    public ResponseCoupon(Long id, Long owner, String name, String image) {
        this.id = id;
        this.owner = owner;
        this.name = name;
        this.image = image;
    }
}
