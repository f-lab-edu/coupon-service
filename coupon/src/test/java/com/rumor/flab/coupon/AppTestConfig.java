package com.rumor.flab.coupon;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.rumor.flab.coupon.application.factory.CouponAutoRegister;
import com.rumor.flab.coupon.application.factory.CouponCustomRegister;
import com.rumor.flab.coupon.application.factory.CouponRegisterFactory;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@TestConfiguration
public class AppTestConfig {

    @Bean
    public CouponRegisterFactory couponRegisterFactory() {
        return new CouponRegisterFactory(couponCustomRegister(), couponAutoRegister());
    }

    @Bean
    public CouponCustomRegister couponCustomRegister() {
        return new CouponCustomRegister(objectMapper());
    }

    @Bean
    public CouponAutoRegister couponAutoRegister() {
        return new CouponAutoRegister();
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }
}
