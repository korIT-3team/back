package com.team.back.service;

import org.springframework.http.ResponseEntity;

import com.team.back.dto.request.auth.SignInRequestDto;
import com.team.back.dto.response.auth.SignInResponseDto;
import com.team.back.dto.response.user.GetSignInUserResponseDto;

public interface UserService {
     // method : 로그인 메서드 //
    ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);
    ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(Integer employeeCode);
}
