package com.team.back.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.back.dto.request.accounting.GetInvoiceListRequestDto;
import com.team.back.dto.request.system.PutCompanyInfoRequestDto;
import com.team.back.dto.request.system.PutCustomerInfoRequestDto;
import com.team.back.dto.request.system.PutDepartmentInfoRequestDto;
import com.team.back.dto.response.accounting.GetInvoiceListResponseDto;
import com.team.back.dto.response.system.DeleteCustomerInfoResponseDto;
import com.team.back.dto.response.system.DeleteDepartmentInfoResponseDto;
import com.team.back.dto.response.system.GetCompanyInfoResponseDto;
import com.team.back.dto.response.system.GetCustomerInfoResponseDto;
import com.team.back.dto.response.system.GetDepartmentInfoResponseDto;
import com.team.back.dto.response.system.Employee.GetSystemEmpUserDefineInfoResponseDto;
import com.team.back.dto.response.system.Employee.GetSystemEmployeeInfoResponseDto;
import com.team.back.dto.response.system.PutCompanyInfoResponseDto;
import com.team.back.dto.response.system.PutCustomerInfoResponseDto;
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

     // API : 부서 정보 등록 메서드 //
     @PutMapping("/dept-info")
     public ResponseEntity<? super PutDepartmentInfoResponseDto> putDepartmentInfo (
          @AuthenticationPrincipal Integer employeeCode,
          @RequestBody @Valid PutDepartmentInfoRequestDto requestBody
     ) {
          ResponseEntity<? super PutDepartmentInfoResponseDto> response = systemManageService.putDepartmentInfo(employeeCode, requestBody);
          return response;
     }

     // API : 부서 정보 삭제 메서드 //
     @DeleteMapping("/dept-info/{departmentCode}")
     public ResponseEntity<? super DeleteDepartmentInfoResponseDto> deleteDepartmentInfo(
          @AuthenticationPrincipal Integer employeeCode,
          @PathVariable(value="departmentCode", required = false) Integer departmnetCode
     ) {
          ResponseEntity<? super DeleteDepartmentInfoResponseDto> responese = systemManageService.deleteDepartmentInfo(employeeCode, departmnetCode);
          return responese;
     }

     // API : 검색 부서 정보 불러오기 메서드 //
     @GetMapping(value={"/dept-info/{departmentName}", "/dept-info"})
     public ResponseEntity<? super GetDepartmentInfoResponseDto> getDepartmentInfo(
          @AuthenticationPrincipal Integer employeeCode,
          @PathVariable(value="departmentName", required=false) String departmentName
     ) {
          ResponseEntity<? super GetDepartmentInfoResponseDto> response = systemManageService.getDepartmentInfo(employeeCode, departmentName);
          return response;
     }

     // API : 검색 사원 정보 불러오기 메서드 //
     @GetMapping(value ={"/employee-info/{systemEmployeeName}", "/employee-info"} )
     public ResponseEntity<? super GetSystemEmployeeInfoResponseDto> getSystemEmployeeInfo(
          @AuthenticationPrincipal Integer employeeCode,
          @PathVariable(value="systemEmployeeName", required=false) String systemEmployeeName
     ) {
          ResponseEntity<? super GetSystemEmployeeInfoResponseDto> response = systemManageService.getSystemEmployeeInfo(employeeCode, systemEmployeeName);
          return response;
     }

     // API : 사원 - 사용자정의 정보 불러오기 메서드
     @GetMapping(value={"/employee-info/user-define/{userDefineCode}"})
     public ResponseEntity<? super GetSystemEmpUserDefineInfoResponseDto> getSystemEmpUserDefineInfo(
          @AuthenticationPrincipal Integer employeeCode,
          @PathVariable(value="userDefineCode", required = false) Integer userDefineCode
     ) {
          ResponseEntity<? super GetSystemEmpUserDefineInfoResponseDto> response = systemManageService.getSystemEmpUserDefineInfo(employeeCode, userDefineCode);
          return response;
     }
     
     //! API : 거래처 정보 등록 메서드 //
     @PutMapping("/customer-info")
     public ResponseEntity<? super PutCustomerInfoResponseDto> putCustomerInfo(
          @AuthenticationPrincipal Integer employeeCode,
          @RequestBody @Valid PutCustomerInfoRequestDto requestBody
     ) {
          ResponseEntity<? super PutCustomerInfoResponseDto> response = systemManageService.putCustomerInfo(employeeCode, requestBody);
          return response;
     }


     // API: 거래처 정보 불러오기 //
     @GetMapping(value={"/customer-info/{customerCode}/{customerName}", "/customer-info"})
     public ResponseEntity<? super GetCustomerInfoResponseDto> getCustomerInfo(
          @AuthenticationPrincipal Integer employeeCode,
          @PathVariable(value="customerCode", required=false) Integer customerCode,
          @PathVariable(value="customerName", required=false) String customerName
     ) {
          ResponseEntity<? super GetCustomerInfoResponseDto> response = systemManageService.getCustomerInfo(employeeCode, customerCode, customerName);
          return response;
     }

     // API : 거래처 정보 삭제 메서드 //
     @DeleteMapping("/customer-info/{customerCode}")
     public ResponseEntity<? super DeleteCustomerInfoResponseDto> deleteCustomerInfo(
          @AuthenticationPrincipal Integer employeeCode,
          @PathVariable(value="customerCode", required = false) Integer customerCode
     ) {
          ResponseEntity<? super DeleteCustomerInfoResponseDto> responese = systemManageService.deleteCustomerInfo(employeeCode, customerCode);
          return responese;
     }

     
     
}
