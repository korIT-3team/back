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

import com.team.back.dto.request.sales.PutSalesPlanInfoRequestDto;
import com.team.back.dto.response.sales.GetSalesPlanListResponseDto;
import com.team.back.dto.response.sales.PutSalesPlanInfoResponseDto;
import com.team.back.dto.response.sales.SalesPlanResponseDto;
import com.team.back.service.SalesService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/sales")
@RequiredArgsConstructor
public class SalesController {

  private final SalesService salesService;
  
  // API: 판매계획 등록 메서드 //
  @PutMapping("/sales-plan")
  public ResponseEntity<? super PutSalesPlanInfoResponseDto> putSalesPlanInfo (
    @AuthenticationPrincipal Integer employeeCode,
    @RequestBody @Valid PutSalesPlanInfoRequestDto requestBody
  ) {
    ResponseEntity<? super PutSalesPlanInfoResponseDto> response = salesService.putSalesPlanInfo(employeeCode, requestBody);
    return response;
  }

  // API: 판매계획 상세 조회 메서드 //
  @GetMapping("/sales-plan/{salesPlanCode}")
  public ResponseEntity<? super SalesPlanResponseDto> getSalesPlanDetail (
    @PathVariable(value="salesPlanCode", required=true) Integer salesPlanCode
  ) {
    ResponseEntity<? super SalesPlanResponseDto> response = salesService.getSalesPlanDetail(salesPlanCode);
    return response;
  }

  // API: 판매계획 조회 메서드 //
  @GetMapping(value={"/sales-plan/{salesPlanCode}", "/sales-plan"})
  public ResponseEntity<? super GetSalesPlanListResponseDto> getSalesPlanList (
    @AuthenticationPrincipal Integer employeeCode,
    @PathVariable(value="salesPlanCode", required=false) Integer salesPlanCode
  ) {
    ResponseEntity<? super GetSalesPlanListResponseDto> response = salesService.getSalesPlanList(employeeCode, salesPlanCode);
    return response;
  }



}
