package com.team.back.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.team.back.filter.JwtAuthenticationFilter;
import com.team.back.handler.OAuth2SuccessHandler;

import lombok.RequiredArgsConstructor;

@EnableWebSecurity
@RequiredArgsConstructor
@Configurable
public class WebSecurityConfig {
     
      private final JwtAuthenticationFilter jwtAuthenticationFilter;
     private final DefaultOAuth2UserService oAuth2UserService;
     private final OAuth2SuccessHandler oAuth2SuccessHandler;
      
      @Bean
	protected SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {

		httpSecurity
            .cors().and()
            .csrf().disable()
            .httpBasic().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .authorizeRequests()
            .antMatchers("/", "/auth/**", "/system/**", "/accounting/**", "/sales/**", "/file/**", "/searchView/**", "/detail-code/**").permitAll()
            .anyRequest().authenticated().and()
            .oauth2Login()
            .redirectionEndpoint().baseUri("/auth/callback/kakao").and()
            .authorizationEndpoint().baseUri("/auth/social").and()  
            .userInfoEndpoint().userService(oAuth2UserService).and()
            .successHandler(oAuth2SuccessHandler);
		
		httpSecurity.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
		
		
		return httpSecurity.build();
	}
}

//! Autorization에 옳지않은 token 값이 올 경우 //
class FailedAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) throws IOException, ServletException {

        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.getWriter().write("{ \"code\": \"AF\", \"message\": \"Authorization Failed\" }");
    }
}