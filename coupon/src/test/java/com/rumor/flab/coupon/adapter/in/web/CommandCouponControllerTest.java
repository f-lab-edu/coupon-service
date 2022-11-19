package com.rumor.flab.coupon.adapter.in.web;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.rumor.flab.coupon.adapter.in.web.enums.ImageGenerationType;
import com.rumor.flab.coupon.application.RegisterCouponService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CommandCouponController.class)
@AutoConfigureMockMvc
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
class CommandCouponControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RegisterCouponService registerCouponService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void coupon() throws Exception {
        RequestCoupon requestCoupon = new RequestCoupon(1L, "설거지쿠폰", "", ImageGenerationType.AUTO);
        String content = objectMapper.writeValueAsString(requestCoupon);

        mockMvc.perform(post("/coupon")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(print());
    }
}