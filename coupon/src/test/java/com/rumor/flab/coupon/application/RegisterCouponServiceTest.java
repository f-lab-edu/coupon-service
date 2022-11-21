package com.rumor.flab.coupon.application;

import com.rumor.flab.coupon.AppTestConfig;
import com.rumor.flab.coupon.adapter.in.web.RequestCoupon;
import com.rumor.flab.coupon.adapter.in.web.enums.ImageGenerationType;
import com.rumor.flab.coupon.application.factory.CouponAutoRegister;
import com.rumor.flab.coupon.application.factory.CouponCustomRegister;
import com.rumor.flab.coupon.application.factory.CouponRegister;
import com.rumor.flab.coupon.application.factory.CouponRegisterFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppTestConfig.class)
class RegisterCouponServiceTest {

    @Autowired
    CouponRegisterFactory couponRegisterFactory;

    @Test
    void 자체제작타입의_경우_Custom_팩토리를_반환해야한다() {
        RequestCoupon requestCoupon = new RequestCoupon(1L, "커피쿠폰", "", ImageGenerationType.CUSTOM);
        CouponRegister couponRegister = couponRegisterFactory.create(requestCoupon.getGenerationType());
        Assertions.assertThat(couponRegister).isInstanceOf(CouponCustomRegister.class);
    }

    @Test
    void 자동타입의_경우_Auto_팩토리를_반환해야한다() {
        RequestCoupon requestCoupon = new RequestCoupon(1L, "커피쿠폰", "", ImageGenerationType.AUTO);
        CouponRegister couponRegister = couponRegisterFactory.create(requestCoupon.getGenerationType());
        Assertions.assertThat(couponRegister).isInstanceOf(CouponAutoRegister.class);
    }
}