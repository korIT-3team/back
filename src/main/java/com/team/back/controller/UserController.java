package com.team.back.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.back.dto.request.auth.SignInRequestDto;
import com.team.back.dto.response.auth.SignInResponseDto;
import com.team.back.dto.response.user.GetSignInUserResponseDto;
import com.team.back.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {
  
     private final UserService userService;

     // API : 로그인 메서드 //
     @PostMapping("/sign-in")
     public ResponseEntity<? super SignInResponseDto> signIn(
     @RequestBody @Valid SignInRequestDto requestBody
     ) {
     ResponseEntity<? super SignInResponseDto> response = userService.signIn(requestBody);
     return response;
     }

     // API : 로그인 유저 정보 불러오기 메서드 //
     @GetMapping("/user")
     public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(
     @AuthenticationPrincipal Integer employeeCode
     ) {
          ResponseEntity<? super GetSignInUserResponseDto> response = userService.getSignInUser(employeeCode);
          return response;
     }

}
