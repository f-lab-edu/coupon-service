package com.rumor.flab.user.application.handler;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.rumor.flab.user.application.exception.GoogleOauthNotFoundUser;
import com.rumor.flab.user.domain.GoogleUser;
import com.rumor.flab.user.domain.SocialUser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

@Component
@RequiredArgsConstructor
public class GoogleOauthHandler implements SocialProviderHandler  {

    @Value("${oauth.google.client.id}")
    private final String CLIENT_ID;

    @Override
    public SocialUser oauthLogin(String credential) {
        try {
            SocialUser socialUser = verify(credential);
            return socialUser;
        } catch (Exception e) {
            throw new RuntimeException("Google Oauth Error");
        }
    }

    private SocialUser verify(String credential) throws GeneralSecurityException, IOException {
        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), new GsonFactory())
                .setAudience(Collections.singleton(CLIENT_ID))
                .build();

        GoogleIdToken idToken = verifier.verify(credential);

        if (idToken == null) {
            throw new GoogleOauthNotFoundUser("해당 토큰으로 유저를 찾을 수 없음");
        }

        GoogleIdToken.Payload payload = idToken.getPayload();

        String userId = payload.getSubject();
        String email = payload.getEmail();

        return new GoogleUser(userId, email);
    }
}
