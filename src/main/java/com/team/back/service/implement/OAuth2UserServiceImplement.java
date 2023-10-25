package com.team.back.service.implement;

import java.util.Map;
import java.util.Optional;

import org.aspectj.weaver.Member;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.team.back.entity.Oauth.KakaoUserInfo;
import com.team.back.entity.Oauth.OAuth2UserEntity;
import com.team.back.repository.OAuth2Repository;
import com.team.back.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OAuth2UserServiceImplement extends DefaultOAuth2UserService {

     private final OAuth2Repository oAuth2Repository;
     
     @Override
     public OAuth2User loadUser(OAuth2UserRequest request) throws OAuth2AuthenticationException {
          
          System.out.println(request.getClientRegistration().getRegistrationId());

          OAuth2User oAuth2User = super.loadUser(request);

          // try {
          //      System.out.println(new ObjectMapper().writeValueAsString(oAuth2User.getAttributes()));
          //      Map<String, String> properties = (Map<String, String>) oAuth2User.getAttributes().get("properties");
          //      String nickname = properties.get("nickname");
          // } catch (Exception exception) {
          //      exception.printStackTrace();
          // }

          String id = oAuth2User.getAttributes().get("id").toString();

          System.out.println(id);

          return new KakaoUserInfo(id, oAuth2User.getAttributes());
     }
}
