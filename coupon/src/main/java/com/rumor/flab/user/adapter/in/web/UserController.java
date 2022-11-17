package com.rumor.flab.user.adapter.in.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class UserController {

    @GetMapping("/user")
    public Map<String, String> user(@AuthenticationPrincipal OAuth2User oAuth2User) {
        return Collections.singletonMap("name", oAuth2User.getName());
    }
}
