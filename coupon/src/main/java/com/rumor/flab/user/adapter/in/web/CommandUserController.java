package com.rumor.flab.user.adapter.in.web;

import com.rumor.flab.user.application.SocialService;
import com.rumor.flab.user.application.enums.SocialType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommandUserController {

    private final SocialService socialService;

    // TODO: 각 소셜마다 로그인시 주어지는 파라미터가 다를 수 있음!
    @PostMapping("/user/google/login")
    public void login(@RequestParam String credential) {
        socialService.login(SocialType.GOOGLE, credential);
    }
}
