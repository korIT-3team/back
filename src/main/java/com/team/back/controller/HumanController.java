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

import com.team.back.dto.request.human.GetHumanDetailRequestDto;
import com.team.back.dto.request.human.PutHumanDetailInfoRequestDto;
import com.team.back.dto.response.human.GetEmploymentTypeListResponseDto;
import com.team.back.dto.response.human.GetHumanDetailInfoResponseDto;
import com.team.back.dto.response.human.GetHumanListResponseDto;
import com.team.back.dto.response.human.GetIncentiveListResponseDto;
import com.team.back.dto.response.human.PutHumanDetailInfoResponseDto;
import com.team.back.service.HumanService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/human")
@RequiredArgsConstructor
public class HumanController {

  private final HumanService humanService;

  //! 인사정보등록 //
  // API : 사원 리스트 불러오기 메서드 //
  @GetMapping(value={"/employee-info-detail/{departmentCode}/{employeeCode}/{employmentType}", "employee-info-detail"})
  public ResponseEntity<? super GetHumanListResponseDto> getHumanList(
    @AuthenticationPrincipal String employeeCode,
    @PathVariable(value="departmentCode", required = false) Integer departmentCode,
    @PathVariable(value="employeeCode", required = false) Integer humanEmployeeCode,
    @PathVariable(value="employmentType", required = false)  Integer employmentType
  ) {
    ResponseEntity<? super GetHumanListResponseDto> response = humanService.getHumanList(employeeCode, departmentCode, humanEmployeeCode, employmentType);
    return response;
  }

  // API : 재직구분(조회조건) 콤보박스 조회 메서드 //
  @GetMapping("/employee-info-detail")
  public ResponseEntity<? super GetEmploymentTypeListResponseDto> getHumanEmploymentType(
  ) {
    ResponseEntity<? super GetEmploymentTypeListResponseDto> response = humanService.getEmploymentType();
    return response;
  }

  // API : 사원Detail정보 불러오기 메서드 //
  @GetMapping(value={"/employee-info-detail/{employeeCode}"})
  public ResponseEntity<? super GetHumanDetailInfoResponseDto> getHumanDetailInfo(
    @RequestBody @Valid GetHumanDetailRequestDto requestBody
  ) {
       ResponseEntity<? super GetHumanDetailInfoResponseDto> response = humanService.getHumanDetailInfo(requestBody);
       return response;
  }

  // API : 사원Detail정보 등록 메서드 //
  @PutMapping("/employee-info-detail")
  public ResponseEntity<? super PutHumanDetailInfoResponseDto> putHumanDetailInfo (
       @AuthenticationPrincipal String employeeCode,
       @RequestBody @Valid PutHumanDetailInfoRequestDto requestBody
  ) {
       ResponseEntity<? super PutHumanDetailInfoResponseDto> response = humanService.putHumanDetailInfo(employeeCode, requestBody);
       return response;
  }

  //! 급/상여정보등록
  @GetMapping("/incentive/{incentiveEmployeeCode}/{incentiveCategory}")
  public ResponseEntity<? super GetIncentiveListResponseDto> getIncentiveList (
    @AuthenticationPrincipal String employeeCode,
    @PathVariable(value="incentiveEmployeeCode", required = false) Integer incentiveEmployeeCode,
    @PathVariable(value="incentiveCategory", required = false) Integer incentiveCategory
  ) {
    ResponseEntity<? super GetIncentiveListResponseDto> response = humanService.getIncentiveList(employeeCode, incentiveEmployeeCode, incentiveCategory);
    return response;
  }

  @GetMapping("/incentive/employee")
  public ResponseEntity<? super GetHumanListResponseDto> getIncentiveEmployeeList (
  ) {
    ResponseEntity<? super GetHumanListResponseDto> response = humanService.getIncentiveEmployeeList();
    return response;
  }
  
}
