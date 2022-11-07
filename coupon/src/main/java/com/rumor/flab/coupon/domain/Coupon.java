package com.rumor.flab.coupon.domain;

import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;

@NoArgsConstructor
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coupon coupon = (Coupon) o;
        return Objects.equals(id, coupon.id) && Objects.equals(owner, coupon.owner) && Objects.equals(name, coupon.name) && Objects.equals(image, coupon.image) && Objects.equals(created, coupon.created) && Objects.equals(updated, coupon.updated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, owner, name, image, created, updated);
    }
}
