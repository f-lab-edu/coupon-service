package com.rumor.flab.user.adapter.in.web;

import com.rumor.flab.user.application.SocialService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class CommandUserController {

    SocialService socialService;

    @PostMapping("/login}")
    public void login() {
        socialService.login();
    }
}
