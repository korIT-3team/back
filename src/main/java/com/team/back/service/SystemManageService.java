package com.team.back.service;


import org.springframework.http.ResponseEntity;

import com.team.back.dto.request.system.PutCompanyInfoRequestDto;
import com.team.back.dto.request.system.PutCustomerInfoRequestDto;
import com.team.back.dto.request.system.PutDepartmentInfoRequestDto;
import com.team.back.dto.request.system.PutProductInfoRequestDto;
import com.team.back.dto.request.system.PutSystemEmployeeInfoRequestDto;
import com.team.back.dto.response.system.DeleteCustomerInfoResponseDto;
import com.team.back.dto.response.system.DeleteDepartmentInfoResponseDto;
import com.team.back.dto.response.system.DeleteProductInfoResponseDto;
import com.team.back.dto.response.system.DeleteSystemEmployeeInfoResponseDto;
import com.team.back.dto.response.system.GetCompanyInfoResponseDto;
import com.team.back.dto.response.system.GetDepartmentInfoResponseDto;
import com.team.back.dto.response.system.GetProductInfoResponseDto;
import com.team.back.dto.response.system.PutCompanyInfoResponseDto;
import com.team.back.dto.response.system.PutCustomerInfoResponseDto;
import com.team.back.dto.response.system.PutDepartmentInfoResponseDto;
import com.team.back.dto.response.system.PutProductInfoResponseDto;
import com.team.back.dto.response.system.PutSystemEmployeeInfoResponseDto;
import com.team.back.dto.response.system.Employee.GetSystemEmpUserDefineInfoResponseDto;
import com.team.back.dto.response.system.Employee.GetSystemEmployeeInfoResponseDto;
import com.team.back.dto.response.system.GetCustomerInfoResponseDto;

public interface SystemManageService {
 
     // API : 회사 정보 불러오기 메서드 //
     ResponseEntity<? super GetCompanyInfoResponseDto> getCompanyInfo();

     // API : 회사 정보 등록 메서드 //
     ResponseEntity<? super PutCompanyInfoResponseDto> putCompanyInfo(String employeeCode, PutCompanyInfoRequestDto dto);

     // API : 부서 정보 등록 메서드 //
     ResponseEntity<? super PutDepartmentInfoResponseDto> putDepartmentInfo(String employeeCode, PutDepartmentInfoRequestDto dto);

     // API : 부서 정보 삭제 메서드 //
     ResponseEntity<? super DeleteDepartmentInfoResponseDto> deleteDepartmentInfo(String employeeCode, Integer deleteDepartmentCode);
     
     // API : 부서 정보 불러오기 //
     ResponseEntity<? super GetDepartmentInfoResponseDto> getDepartmentInfo(String employeeCode, String departmentName);

     // API : 사원 정보 등록 메서드 //
     ResponseEntity<? super PutSystemEmployeeInfoResponseDto> putSystemEmployeeInfo(String employeeCode, PutSystemEmployeeInfoRequestDto dto);

     // API : 사원 정보 삭제 메서드 //
     ResponseEntity<? super DeleteSystemEmployeeInfoResponseDto> deleteSystemEmployeeInfo(String employeeCode, Integer deleteSystemEmployeeCode);
  
     // API : 사원 정보 불러오기 //
     ResponseEntity<? super GetSystemEmployeeInfoResponseDto> getSystemEmployeeInfo(String employeeCode, String systemEmployeeName);

     // API : 사원 - 코드도움 불러오기 //
     ResponseEntity<? super GetSystemEmpUserDefineInfoResponseDto> getSystemEmpUserDefineInfo(String employeeCode, Integer userDefineCode);

     // API : 거래처 정보 불러오기 메서드 //
     ResponseEntity<? super GetCustomerInfoResponseDto> getCustomerInfo(String employeeCode, String customerName);

     // API : 거래처 정보 등록 메서드 //
     ResponseEntity<? super PutCustomerInfoResponseDto> putCustomerInfo(String employeeCode, PutCustomerInfoRequestDto dto);

     // API : 거래처 정보 삭제 메서드 //
     ResponseEntity<? super DeleteCustomerInfoResponseDto> deleteCustomerInfo(String employeeCode, Integer deleteCustomerCode);

     // API : 품목 정보 불러오기 메서드 //
     ResponseEntity<? super GetProductInfoResponseDto> getProductInfo(String employeeCode, String productName);

     // API : 품목 정보 등록 메서드 //
     ResponseEntity<? super PutProductInfoResponseDto> putProductInfo(String employeeCode, PutProductInfoRequestDto dto);

     // API : 품목 정보 삭제 메서드 //
     ResponseEntity<? super DeleteProductInfoResponseDto> deleteProductInfo(String employeeCode, Integer deleteProductCode);

}
