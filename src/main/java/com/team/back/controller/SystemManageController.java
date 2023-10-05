package com.team.back.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.back.dto.request.accounting.GetInvoiceListRequestDto;
import com.team.back.dto.request.system.GetDepartmentListRequestDto;
import com.team.back.dto.request.system.PutCompanyInfoRequestDto;
import com.team.back.dto.request.system.PutDepartmentInfoRequestDto;
import com.team.back.dto.response.accounting.GetInvoiceListResponseDto;
import com.team.back.dto.response.system.GetCompanyInfoResponseDto;
import com.team.back.dto.response.system.GetCustomerInfoResponseDto;
import com.team.back.dto.response.system.GetDepartmentInfoResponseDto;
import com.team.back.dto.response.system.PutCompanyInfoResponseDto;
import com.team.back.dto.response.system.PutDepartmentInfoResponseDto;
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

     // API : 부서 정보 불러오기
     // @GetMapping("/dept-info")
     // public ResponseEntity<? super GetDepartmentInfoResponseDto> getDepartmentInfo(
     // ) {
     //      ResponseEntity<? super GetDepartmentInfoResponseDto> response = systemManageService.getDepartmentInfo();
     //      return response;
     // }
//
     // API : 부서 정보 등록 메서드 //
     @PutMapping("/dept-info")
     public ResponseEntity<? super PutDepartmentInfoResponseDto> putDepartmentInfo (
          @AuthenticationPrincipal Integer employeeCode,
          @RequestBody @Valid PutDepartmentInfoRequestDto requestBody
     ) {
          ResponseEntity<? super PutDepartmentInfoResponseDto> response = systemManageService.putDepartmentInfo(employeeCode, requestBody);
          return response;
     }

     // API : 검색 부서 정보 불러오기 메서드 //
<<<<<<< HEAD
     // @GetMapping(value={"/dept-info/{departmentName}"})
     // public ResponseEntity<? super GetSearchDepartmentInfoResponseDto> getSearchDepartment(
     // @PathVariable(value="departmentName", required=true) String departmentName
     // ) {
     // ResponseEntity<? super GetSearchDepartmentInfoResponseDto> response = 
     //      systemManageService.getSearchDepartment(departmentName);
     // return response;
     // }
=======
     @GetMapping(value={"/dept-info"})
     public ResponseEntity<? super GetDepartmentInfoResponseDto> getDepartmentInfo(
          @AuthenticationPrincipal Integer employeeCode,
          @RequestBody @Valid GetDepartmentListRequestDto requestBody
     ) {
     ResponseEntity<? super GetDepartmentInfoResponseDto> response = systemManageService.getDepartmentInfo(employeeCode, requestBody);
     return response;
     }
>>>>>>> 09f7b466063b9a5c203238a83669cdfad2eafe9a

     // API: 거래처 불러오기 //
     @GetMapping("/customer-info")
     public ResponseEntity<? super GetCustomerInfoResponseDto> getCustomerInfo(
     ) {
          ResponseEntity<? super GetCustomerInfoResponseDto> response = systemManageService.getCustomerInfo();
          return response;
     }
}
