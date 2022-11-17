package com.rumor.flab.coupon.application;

import com.rumor.flab.coupon.adapter.in.web.RequestCoupon;
import com.rumor.flab.coupon.adapter.in.web.enums.ImageGenerationType;
import com.rumor.flab.coupon.application.factory.CouponAutoRegister;
import com.rumor.flab.coupon.application.factory.CouponCustomRegister;
import com.rumor.flab.coupon.application.factory.CouponRegister;
import com.rumor.flab.coupon.application.factory.CouponRegisterFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RegisterCouponServiceTest {

    @Test
    void 자체제작타입의_경우_Custom_팩토리를_반환해야한다() {
        RequestCoupon requestCoupon = new RequestCoupon(1L, "커피쿠폰", "", ImageGenerationType.CUSTOM);
        CouponRegister couponRegister = CouponRegisterFactory.create(requestCoupon.getGenerationType());
        Assertions.assertThat(couponRegister).isInstanceOf(CouponCustomRegister.class);
    }

    @Test
    void 자동타입의_경우_Auto_팩토리를_반환해야한다() {
        RequestCoupon requestCoupon = new RequestCoupon(1L, "커피쿠폰", "", ImageGenerationType.AUTO);
        CouponRegister couponRegister = CouponRegisterFactory.create(requestCoupon.getGenerationType());
        Assertions.assertThat(couponRegister).isInstanceOf(CouponAutoRegister.class);
    }

    @Test
    void couponRegisterFactory는_ImageGenerationType만_받을_수_있어야_한다() {
        Assertions.assertThatThrownBy(() -> {
           // CouponRegister couponRegister = CouponRegisterFactory.create("2");
        });
    }
}