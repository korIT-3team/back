package com.team.back.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.back.dto.request.SignInRequestDto;
import com.team.back.dto.response.SignInResponseDto;
import com.team.back.service.MainService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class MainController {
  
     private final MainService mainService;

     // API : 로그인 메서드 //
     @PostMapping("/sign-in")
     public ResponseEntity<? super SignInResponseDto> signIn(
     @RequestBody @Valid SignInRequestDto requestBody
     ) {
     ResponseEntity<? super SignInResponseDto> response = mainService.signIn(requestBody);
     return response;
     }

     // API : 로그인 메서드 //
     @GetMapping("")
     public String hello(){ 
          return "hello";
     }

}
