package com.team.back.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.back.dto.request.common.GetEmployeeDetailCodeRequestDto;
import com.team.back.dto.response.common.GetSearchCodeListResponseDto;
import com.team.back.service.SearchCodeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/detail-code")
@RequiredArgsConstructor
public class SearchCodeController {
     private final SearchCodeService searchCodeService;

     // API : 사원 목록 조회 메서드 //
     @PostMapping("")
     public ResponseEntity<? super GetSearchCodeListResponseDto> getEmployeeList(
          @RequestBody @Valid GetEmployeeDetailCodeRequestDto requestBody
     ) {
          ResponseEntity<? super GetSearchCodeListResponseDto> response = searchCodeService.getEmployeeList(requestBody);
          return response;
     }
}
