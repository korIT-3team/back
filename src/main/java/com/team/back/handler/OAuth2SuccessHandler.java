package com.team.back.handler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.team.back.entity.Oauth.KakaoUserInfo;
import com.team.back.provider.JwtProvider;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
     
     private final JwtProvider jwtProvider;

     @Override
     public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {

          KakaoUserInfo oAuth2User = (KakaoUserInfo) authentication.getPrincipal();
          String id = oAuth2User.getName();
          System.out.println(id);
          String token = jwtProvider.create(id);

          response.sendRedirect("http://localhost:3000/oauth2/" + token);
     }
}
