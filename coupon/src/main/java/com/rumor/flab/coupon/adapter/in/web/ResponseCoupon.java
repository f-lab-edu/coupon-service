package com.rumor.flab.coupon.adapter.in.web;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseCoupon that = (ResponseCoupon) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(owner, that.owner) &&
                Objects.equals(name, that.name) &&
                Objects.equals(image, that.image) &&
                Objects.equals(created, that.created) &&
                Objects.equals(updated, that.updated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, owner, name, image, created, updated);
    }
}
