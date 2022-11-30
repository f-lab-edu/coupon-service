package com.rumor.flab.user.application.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.google.api.client.auth.openidconnect.IdTokenVerifier;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.rumor.flab.user.application.dto.GoogleTokenRequest;
import com.rumor.flab.user.application.dto.GoogleTokenResponse;
import com.rumor.flab.user.application.exception.GoogleOauthNotFoundUser;
import com.rumor.flab.user.application.dto.GoogleUser;
import com.rumor.flab.user.application.dto.SocialUser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
public class GoogleOauthHandler implements SocialProviderHandler  {

    private final String CLIENT_ID;
    private final String CLIENT_SECRET;
    private final String REDIRECT_URI;
    private final String GOOGLE_OAUTH_BASE_URL;
    private final RestTemplate restTemplate;
    private final ObjectMapper snakeCaseObjectMapper;

    public GoogleOauthHandler(@Value("${oauth.google.client.id}") String CLIENT_ID,
                              @Value("${oauth.google.client.secret}") String CLIENT_SECRET,
                              @Value("${oauth.google.redirect.uri}") String REDIRECT_URI,
                              @Value("${oauth.google.api.url}") String GOOGLE_OAUTH_BASE_URL,
                              RestTemplate restTemplate, ObjectMapper snakeCaseObjectMapper) {
        this.CLIENT_ID = CLIENT_ID;
        this.CLIENT_SECRET = CLIENT_SECRET;
        this.REDIRECT_URI = REDIRECT_URI;
        this.GOOGLE_OAUTH_BASE_URL = GOOGLE_OAUTH_BASE_URL;
        this.restTemplate = restTemplate;
        this.snakeCaseObjectMapper = snakeCaseObjectMapper;
    }

    @Override
    public SocialUser oauthLogin(String credential) {
        try {
            GoogleTokenResponse googleTokenResponse = requestAccessToken(credential);
            SocialUser socialUser = verify(googleTokenResponse);
            return socialUser;
        } catch (Exception e) {
            throw new RuntimeException("Google Oauth Error");
        }
    }

    private GoogleTokenResponse requestAccessToken(String code) throws JsonProcessingException {
        GoogleTokenRequest googleTokenRequest = new GoogleTokenRequest(code, CLIENT_ID, CLIENT_SECRET, REDIRECT_URI, "authorization_code");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<GoogleTokenRequest> googleTokenRequestHttpEntity = new HttpEntity<>(googleTokenRequest, httpHeaders);
        ResponseEntity<String> response = restTemplate.postForEntity(GOOGLE_OAUTH_BASE_URL, googleTokenRequestHttpEntity, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return snakeCaseObjectMapper.readValue(response.getBody(), GoogleTokenResponse.class);
        }

        return null;
    }

    private SocialUser verify(GoogleTokenResponse googleTokenResponse) throws IOException {
        if (googleTokenResponse == null) {
            throw new RuntimeException("토큰이 존재하지 않습니다");
        }

        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), new GsonFactory())
                .setAudience(Collections.singleton(CLIENT_ID))
                .build();

        GoogleIdToken idToken = GoogleIdToken.parse(verifier.getJsonFactory(), googleTokenResponse.getIdToken());

        if (idToken == null) {
            throw new GoogleOauthNotFoundUser("해당 토큰으로 유저를 찾을 수 없음");
        }

        GoogleIdToken.Payload payload = idToken.getPayload();

        String userId = payload.getSubject();
        String email = payload.getEmail();
        String locale = (String) payload.get("locale");

        return new GoogleUser(userId, email, locale);
    }
}
