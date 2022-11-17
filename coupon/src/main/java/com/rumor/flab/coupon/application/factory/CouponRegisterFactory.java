package com.rumor.flab.coupon.application.factory;

import com.rumor.flab.coupon.adapter.in.web.enums.ImageGenerationType;
import com.rumor.flab.coupon.application.exception.NotFoundRegisterTypeException;

public class CouponRegisterFactory {

    public static CouponRegister create(ImageGenerationType generationType) {
        if (ImageGenerationType.AUTO == generationType) {
            return new CouponAutoRegister();
        }

        if (ImageGenerationType.CUSTOM == generationType) {
            return new CouponCustomRegister();
        }

        // TODO: 어차피 ImageGenerationType만 받을 수 있다.
        throw new NotFoundRegisterTypeException("쿠폰 이미지 등록 타입을 확인해주세요!");
    }
}
