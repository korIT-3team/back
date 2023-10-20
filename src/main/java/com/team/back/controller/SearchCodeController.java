package com.team.back.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.back.dto.request.common.GetCustomerDetailCodeRequestDto;
import com.team.back.dto.request.common.GetDepartmentDetailCodeRequestDto;
import com.team.back.dto.request.common.GetEmployeeDetailCodeRequestDto;
import com.team.back.dto.request.common.GetProjectDetailCodeRequestDto;
import com.team.back.dto.response.common.GetSearchCodeListResponseDto;
import com.team.back.service.SearchCodeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/detail-code")
@RequiredArgsConstructor
public class SearchCodeController {
     private final SearchCodeService searchCodeService;

     // API : 사원코드도움 메서드 //
     @PostMapping("employee")
     public ResponseEntity<? super GetSearchCodeListResponseDto> getEmployeeList(
          @RequestBody @Valid GetEmployeeDetailCodeRequestDto requestBody
     ) {
          ResponseEntity<? super GetSearchCodeListResponseDto> response = searchCodeService.getEmployeeList(requestBody);
          return response;
     }

     // API : 부서코드도움 메서드 //
     @PostMapping("department")
     public ResponseEntity<? super GetSearchCodeListResponseDto> getDepartmentList(
          @RequestBody @Valid GetDepartmentDetailCodeRequestDto requestBody
     ) {
          ResponseEntity<? super GetSearchCodeListResponseDto> response = searchCodeService.getDepartmentList(requestBody);
          return response;
     }

     // API : 거래처코드도움 메서드 //
     @PostMapping("customer")
     public ResponseEntity<? super GetSearchCodeListResponseDto> getCustomerList(
          @RequestBody @Valid GetCustomerDetailCodeRequestDto requestBody
     ) {
          ResponseEntity<? super GetSearchCodeListResponseDto> response = searchCodeService.getCustomerList(requestBody);
          return response;
     }

     // API : 판매계획코드도움 메서드 //
     @PostMapping("sales-plan")
     public ResponseEntity<? super GetSearchCodeListResponseDto> getProjecttList(
          @RequestBody @Valid GetProjectDetailCodeRequestDto requestBody
     ) {
          ResponseEntity<? super GetSearchCodeListResponseDto> response = searchCodeService.getProjecttList(requestBody);
          return response;
     }
}
