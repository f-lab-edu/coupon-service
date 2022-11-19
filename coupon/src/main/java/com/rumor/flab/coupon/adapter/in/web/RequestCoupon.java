package com.rumor.flab.coupon.adapter.in.web;

import com.rumor.flab.coupon.adapter.in.web.enums.ImageGenerationType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RequestCoupon {
    private Long owner;
    private String name;
    private String image;
    private ImageGenerationType generationType;

    public RequestCoupon(Long owner, String name, String image, ImageGenerationType generationType) {
        this.owner = owner;
        this.name = name;
        this.image = image;
        this.generationType = generationType;
    }

    public ImageGenerationType getGenerationType() {
        return generationType;
    }
}