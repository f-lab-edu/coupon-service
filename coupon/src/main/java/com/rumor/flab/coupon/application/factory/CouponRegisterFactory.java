package com.rumor.flab.coupon.application.factory;

import com.rumor.flab.coupon.adapter.in.web.enums.ImageGenerationType;
import com.rumor.flab.coupon.application.exception.NotFoundRegisterTypeException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CouponRegisterFactory {

    private final CouponRegister couponCustomRegister;
    private final CouponRegister couponAutoRegister;

    public CouponRegister create(ImageGenerationType generationType) {
        if (ImageGenerationType.AUTO == generationType) {
            return couponAutoRegister;
        }

        if (ImageGenerationType.CUSTOM == generationType) {
            return couponCustomRegister;
        }

        // TODO: 어차피 ImageGenerationType만 받을 수 있다.
        throw new NotFoundRegisterTypeException("쿠폰 이미지 등록 타입을 확인해주세요!");
    }
}
