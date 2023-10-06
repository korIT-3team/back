package com.team.back.service;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.team.back.dto.request.accounting.GetInvoiceListRequestDto;
import com.team.back.dto.request.system.GetDepartmentListRequestDto;
import com.team.back.dto.request.system.PutCompanyInfoRequestDto;
import com.team.back.dto.request.system.PutCustomerInfoRequestDto;
import com.team.back.dto.request.system.PutDepartmentInfoRequestDto;
import com.team.back.dto.request.system.PutProductInfoRequestDto;
import com.team.back.dto.response.system.GetCompanyInfoResponseDto;
import com.team.back.dto.response.system.GetDepartmentInfoResponseDto;
import com.team.back.dto.response.system.GetProductInfoResponseDto;
import com.team.back.dto.response.system.PutCompanyInfoResponseDto;
import com.team.back.dto.response.system.PutCustomerInfoResponseDto;
import com.team.back.dto.response.system.PutDepartmentInfoResponseDto;
import com.team.back.dto.response.system.GetCustomerInfoResponseDto;

public interface SystemManageService {
 
     // API : 회사 정보 불러오기 메서드 //
     ResponseEntity<? super GetCompanyInfoResponseDto> getCompanyInfo();

     // API : 회사 정보 등록 메서드 //
     ResponseEntity<? super PutCompanyInfoResponseDto> putCompanyInfo(Integer employeeCode, PutCompanyInfoRequestDto dto);

     // API : 부서 정보 등록 메서드 //
     ResponseEntity<? super PutDepartmentInfoResponseDto> putDepartmentInfo(Integer employeeCode, PutDepartmentInfoRequestDto dto);
     
     // API : 부서 정보 불러오기 //
     ResponseEntity<? super GetDepartmentInfoResponseDto> getDepartmentInfo(Integer employeeCode, String departmentName);
  
     // API : 거래처 정보 불러오기 메서드 //
     ResponseEntity<? super GetCustomerInfoResponseDto> getCustomerInfo();

     // API : 거래처 정보 등록 메서드 //
     ResponseEntity<? super PutCustomerInfoResponseDto> putCustomerInfo(Integer employeeCode, PutCustomerInfoRequestDto dto);

     // API : 품목 정보 불러오기 메서드 //
     ResponseEntity<? super GetProductInfoResponseDto> getProductInfo();

     // API : 품목 정보 등록 메서드 //
     ResponseEntity<?> putProductInfo(Integer employeeCode, PutProductInfoRequestDto dto);

}
