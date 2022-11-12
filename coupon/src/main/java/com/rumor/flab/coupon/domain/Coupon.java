package com.rumor.flab.coupon.domain;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Objects;

@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Coupon {
    private Long id;
    private Long owner;
    private String name;
    private String image;
    private LocalDate created;
    private LocalDate updated;

    public Coupon(Long id, Long owner, String name, String image, LocalDate created, LocalDate updated) {
        this.id = id;
        this.owner = owner;
        this.name = name;
        this.image = image;
        this.created = created;
        this.updated = updated;
    }
}
