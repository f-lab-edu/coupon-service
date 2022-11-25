package com.rumor.flab.user.adapter.in.web;

import com.rumor.flab.user.application.SocialService;
import com.rumor.flab.user.application.enums.SocialType;
import com.rumor.flab.user.application.port.in.SocialLoginUserCase;
import com.rumor.flab.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
public class CommandUserController {

    private final SocialLoginUserCase socialLoginUserCase;

    @Value("{$oauth.google.account.url}")
    private String GOOGLE_ACCOUNT_URL;

    public String login() {
//        String authentication = socialLoginUserCase.authentication();
//        return String.format("redirect:%s", authentication);
        return null;
    }

    // TODO: 각 소셜마다 로그인시 주어지는 파라미터가 다를 수 있음!
    @GetMapping("/user/google/login")
    public String googleLogin(@RequestParam String code, HttpServletRequest request) {
        User user = socialLoginUserCase.login(SocialType.GOOGLE, code);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        return "OK";
    }
}
