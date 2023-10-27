package com.team.back.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.back.dto.request.sales.PutSalesPlanInfoRequestDto;
import com.team.back.dto.response.sales.DeleteSalesPlanInfoResponseDto;
import com.team.back.dto.response.sales.GetSalesPlanInfoResponseDto;
import com.team.back.dto.response.sales.PutSalesPlanInfoResponseDto;
import com.team.back.service.SalesService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/sales")
@RequiredArgsConstructor
public class SalesController {

  private final SalesService salesService;
  
  // API: salesPlan 정보 등록 메서드 //
  @PutMapping("/sales-plan")
  public ResponseEntity<? super PutSalesPlanInfoResponseDto> putSalesPlanInfo (
    @AuthenticationPrincipal Integer employeeCode,
    @RequestBody @Valid PutSalesPlanInfoRequestDto requestBody
  ) {
    ResponseEntity<? super PutSalesPlanInfoResponseDto> response = salesService.putSalesPlanInfo(employeeCode, requestBody);
    return response;
  }

  // API: salesPlan 정보 삭제 메서드 //
  @DeleteMapping("/sales-plan/{salesPlanCode}")
  public ResponseEntity<? super DeleteSalesPlanInfoResponseDto> deleteSalesPlanInfo(
    @AuthenticationPrincipal Integer employeeCode,
    @PathVariable(value="salesPlanCode", required = false) Integer deleteSalesPlanCode
  ) {
    ResponseEntity<? super DeleteSalesPlanInfoResponseDto> response = salesService.deleteSalesPlanInfo(employeeCode, deleteSalesPlanCode);
    return response;
  }

  // API: search salesPlan 정보 불러오기 메서드 //
  @GetMapping(value={"/sales-plan/{salesPlanCode}", "/sales-plan/{projectName}", "/sales-plan/{planDate}" })
  public ResponseEntity<? super GetSalesPlanInfoResponseDto> getSalesPlanInfo(
    @AuthenticationPrincipal Integer employeeCode,
    @PathVariable(value="salesPlanCode", required=false) Integer salesPlanCode,
    @PathVariable(value="projectName", required=false) String projectName,
    @PathVariable(value="planDate", required=false) String planDate
  ) {
    ResponseEntity<? super GetSalesPlanInfoResponseDto> response = salesService.getSalesPlanInfo(employeeCode, salesPlanCode, projectName, planDate);
    return response;
  }


}
