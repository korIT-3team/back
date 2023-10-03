package com.team.back.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.back.dto.request.system.PutCompanyInfoRequestDto;
import com.team.back.dto.response.system.GetCompanyInfoResponseDto;
import com.team.back.dto.response.system.PutCompanyInfoResponseDto;
import com.team.back.service.SystemManageService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/system")
@RequiredArgsConstructor
public class SystemManageController {
     
     private final SystemManageService systemManageService;

     // API : 회사 정보 불러오기 메서드 //
     @GetMapping("/company-info")
     public ResponseEntity<? super GetCompanyInfoResponseDto> getCompanyInfo(
     ) {
          ResponseEntity<? super GetCompanyInfoResponseDto> response = systemManageService.getCompanyInfo();
          return response;
     }

     // API : 회사 정보 등록 메서드 //
     @PutMapping("/company-info")
     public ResponseEntity<? super PutCompanyInfoResponseDto> putCompanyInfo(
          @AuthenticationPrincipal Integer employeeCode,
          @RequestBody @Valid PutCompanyInfoRequestDto requestBody
     ) {
          ResponseEntity<? super PutCompanyInfoResponseDto> response = systemManageService.putCompanyInfo(employeeCode, requestBody);
          return response;
     }
}
