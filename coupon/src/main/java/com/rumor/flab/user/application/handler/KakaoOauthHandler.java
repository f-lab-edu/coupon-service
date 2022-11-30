package com.rumor.flab.user.application.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rumor.flab.user.application.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Base64;
import java.util.Map;

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
        try {
            KakaoTokenResponse kakaoTokenResponse = requestAccessToken(code);
            SocialUser socialUser = verify(kakaoTokenResponse);
            return socialUser;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("KaKao Oauth Error");
        }
    }

    private SocialUser verify(KakaoTokenResponse kakaoTokenResponse) throws IOException {
        String idToken = kakaoTokenResponse.getIdToken();
        String[] chunks = idToken.split("\\.");

        Base64.Decoder decoder = Base64.getUrlDecoder();
        String payload = new String(decoder.decode(chunks[1]));

        Map map = snakeCaseObjectMapper.readValue(payload, Map.class);
        String userId = (String) map.get("sub");
        String email = (String) map.get("email");

        return new KakaoUser(userId, email, "");
    }

    private KakaoTokenResponse requestAccessToken(String code) throws JsonProcessingException {
        KaKaoTokenRequest kaKaoTokenRequest = new KaKaoTokenRequest(code, CLIENT_ID, CLIENT_SECRET, REDIRECT_URI, "authorization_code");
        MultiValueMap param = new LinkedMultiValueMap();
        param.add("code", kaKaoTokenRequest.getCode());
        param.add("client_id", kaKaoTokenRequest.getClientId());
        param.add("client_secret", kaKaoTokenRequest.getClientSecret());
        param.add("grant_type", kaKaoTokenRequest.getGrantType());
        param.add("redirect_uri", kaKaoTokenRequest.getRedirectUri());

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap> tokenRequestHttpEntity = new HttpEntity<>(param, httpHeaders);
        ResponseEntity<String> response = restTemplate.postForEntity(KAKAO_OAUTH_BASE_URL, tokenRequestHttpEntity, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return snakeCaseObjectMapper.readValue(response.getBody(), KakaoTokenResponse.class);
        }

        return null;
    }
}
