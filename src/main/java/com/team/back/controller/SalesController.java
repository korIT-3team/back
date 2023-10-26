package com.team.back.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.back.dto.request.sales.PutSalesPlanInfoRequestDto;
import com.team.back.dto.response.sales.PutSalesPlanInfoResponseDto;
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
    @AuthenticationPrincipal String employeeCode,
    @RequestBody @Valid PutSalesPlanInfoRequestDto requestBody
  ) {
    ResponseEntity<? super PutSalesPlanInfoResponseDto> response = salesService.putSalesPlanInfo(employeeCode, requestBody);
    return response;
  }


}
