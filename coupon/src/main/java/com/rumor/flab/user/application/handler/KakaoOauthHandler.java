package com.rumor.flab.user.application.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rumor.flab.user.application.dto.KaKaoTokenRequest;
import com.rumor.flab.user.application.dto.KakaoTokenResponse;
import com.rumor.flab.user.application.dto.SocialUser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class KakaoOauthHandler implements SocialProviderHandler {

    @Value("${oauth.kakao.client.id}")
    private String CLIENT_ID;

    @Value("${oauth.kakao.client.secret}")
    private String CLIENT_SECRET;

    @Value("${oauth.kakao.redirect.uri}")
    private String REDIRECT_URI;

    @Value("${oauth.kakao.api.url}")
    private String KAKAO_OAUTH_BASE_URL;

    private final RestTemplate restTemplate;

    private final ObjectMapper snakeCaseObjectMapper;

    @Override
    public SocialUser oauthLogin(String code) {
        requestAccessToken(code);
    }

    private void requestAccessToken(String code) throws JsonProcessingException {
        KaKaoTokenRequest kaKaoTokenRequest = new KaKaoTokenRequest(code, CLIENT_ID, CLIENT_SECRET, REDIRECT_URI, KAKAO_OAUTH_BASE_URL);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<KaKaoTokenRequest> tokenRequestHttpEntity = new HttpEntity<>(kaKaoTokenRequest, httpHeaders);
        ResponseEntity<String> response = restTemplate.postForEntity(KAKAO_OAUTH_BASE_URL, tokenRequestHttpEntity, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            snakeCaseObjectMapper.readValue(response.getBody(), KakaoTokenResponse.class);
        }



    }
}
