package com.team.back.service;

import org.springframework.http.ResponseEntity;

import com.team.back.dto.request.system.PutCompanyInfoRequestDto;
import com.team.back.dto.response.system.GetCompanyInfoResponseDto;
import com.team.back.dto.response.system.GetDepartmentInfoResponseDto;
import com.team.back.dto.response.system.PutCompanyInfoResponseDto;
import com.team.back.dto.response.system.GetCustomerInfoResponseDto;

public interface SystemManageService {
 
     // API : 회사 정보 불러오기 메서드 //
     ResponseEntity<? super GetCompanyInfoResponseDto> getCompanyInfo();

     // API : 회사 정보 등록 메서드 //
     ResponseEntity<? super PutCompanyInfoResponseDto> putCompanyInfo(Integer employeeCode, PutCompanyInfoRequestDto dto);

     // API : 부서 정보 불러오기
     ResponseEntity<? super GetDepartmentInfoResponseDto> getDepartmentInfo();

     // API : 거래처 불러오기 메서드 //
     ResponseEntity<? super GetCustomerInfoResponseDto> getCustomerInfo();

}
