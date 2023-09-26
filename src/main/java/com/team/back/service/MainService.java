package com.team.back.service;

import org.springframework.http.ResponseEntity;

import com.team.back.dto.request.SignInRequestDto;
import com.team.back.dto.response.SignInResponseDto;

public interface MainService {
     // method : 로그인 메서드 //
    ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);
}
