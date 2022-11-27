package com.rumor.flab.user.adapter.in.web;

import com.rumor.flab.user.application.SocialService;
import com.rumor.flab.user.application.enums.SocialType;
import com.rumor.flab.user.application.port.in.SocialLoginUserCase;
import com.rumor.flab.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class CommandUserController {

    private final SocialLoginUserCase socialLoginUserCase;

    @Value("${oauth.google.account.url}")
    private String GOOGLE_ACCOUNT_URL;

    @GetMapping("/user/google/authentication")
    public String googleAuthentication(HttpSession session) {
        User user = (User) session.getAttribute("user");

        if (user != null) {
            return "redirect:/?referrer=authentication";
        }

        return "redirect:" + GOOGLE_ACCOUNT_URL;
    }

    @GetMapping("/user/google/login")
    public String googleLogin(@RequestParam String code, HttpServletRequest request) {
        User user = socialLoginUserCase.login(SocialType.GOOGLE, code);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        return "redirect:/?referrer=login";
    }
}
