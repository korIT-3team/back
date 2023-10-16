package com.team.back.service;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.team.back.dto.request.accounting.GetInvoiceListRequestDto;
import com.team.back.dto.request.system.PutCompanyInfoRequestDto;
import com.team.back.dto.request.system.PutCustomerInfoRequestDto;
import com.team.back.dto.request.system.PutDepartmentInfoRequestDto;
import com.team.back.dto.request.system.PutProductInfoRequestDto;
import com.team.back.dto.response.system.DeleteCustomerInfoResponseDto;
import com.team.back.dto.response.system.DeleteDepartmentInfoResponseDto;
import com.team.back.dto.response.system.GetCompanyInfoResponseDto;
import com.team.back.dto.response.system.GetDepartmentInfoResponseDto;
import com.team.back.dto.response.system.GetProductInfoResponseDto;
import com.team.back.dto.response.system.PutCompanyInfoResponseDto;
import com.team.back.dto.response.system.PutCustomerInfoResponseDto;
import com.team.back.dto.response.system.PutDepartmentInfoResponseDto;
import com.team.back.dto.response.system.Employee.GetSystemEmpUserDefineInfoResponseDto;
import com.team.back.dto.response.system.Employee.GetSystemEmployeeInfoResponseDto;
import com.team.back.dto.response.system.GetCustomerInfoResponseDto;

public interface SystemManageService {
 
     // API : 회사 정보 불러오기 메서드 //
     ResponseEntity<? super GetCompanyInfoResponseDto> getCompanyInfo();

     // API : 회사 정보 등록 메서드 //
     ResponseEntity<? super PutCompanyInfoResponseDto> putCompanyInfo(Integer employeeCode, PutCompanyInfoRequestDto dto);

     // API : 부서 정보 등록 메서드 //
     ResponseEntity<? super PutDepartmentInfoResponseDto> putDepartmentInfo(Integer employeeCode, PutDepartmentInfoRequestDto dto);

     // API : 부서 정보 삭제 메서드 //
     ResponseEntity<? super DeleteDepartmentInfoResponseDto> deleteDepartmentInfo(Integer employeeCode, Integer deleteDepartmentCode);
     
     // API : 부서 정보 불러오기 //
     ResponseEntity<? super GetDepartmentInfoResponseDto> getDepartmentInfo(Integer employeeCode, String departmentName);
  
     // API : 사원 정보 불러오기 //
     ResponseEntity<? super GetSystemEmployeeInfoResponseDto> getSystemEmployeeInfo(Integer employeeCode, String systemEmployeeName);

     // API : 사원 - 코드도움 불러오기 //
     ResponseEntity<? super GetSystemEmpUserDefineInfoResponseDto> getSystemEmpUserDefineInfo(Integer employeeCode, Integer userDefineCode);

     // API : 거래처 정보 불러오기 메서드 //
     ResponseEntity<? super GetCustomerInfoResponseDto> getCustomerInfo(Integer employeeCode, Integer customerCode, String customerName);

     // API : 거래처 정보 등록 메서드 //
     ResponseEntity<? super PutCustomerInfoResponseDto> putCustomerInfo(Integer employeeCode, PutCustomerInfoRequestDto dto);

     // API : 거래처 정보 삭제 메서드 //
     ResponseEntity<? super DeleteCustomerInfoResponseDto> deleteCustomerInfo(Integer employeeCode, Integer deleteCustomerCode);

     // API : 품목 정보 불러오기 메서드 //
     ResponseEntity<? super GetProductInfoResponseDto> getProductInfo();

     // API : 품목 정보 등록 메서드 //
     ResponseEntity<?> putProductInfo(Integer employeeCode, PutProductInfoRequestDto dto);

}
