package com.rumor.flab.coupon.adapter.in.web;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class ResponseCoupon {

    private Long id;
    private Long owner;
    private String name;
    private String image;
    private LocalDate created;
    private LocalDate updated;

    public ResponseCoupon(Long id, Long owner, String name, String image, LocalDate created, LocalDate updated) {
        this.id = id;
        this.owner = owner;
        this.name = name;
        this.image = image;
        this.created = created;
        this.updated = updated;
    }
}
