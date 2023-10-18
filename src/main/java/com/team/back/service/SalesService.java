package com.team.back.service;

import org.springframework.http.ResponseEntity;

import com.team.back.dto.request.sales.PutSalesPlanInfoRequestDto;
import com.team.back.dto.response.sales.GetSalesPlanListResponseDto;
import com.team.back.dto.response.sales.PutSalesPlanInfoResponseDto;
import com.team.back.dto.response.sales.SalesPlanResponseDto;

public interface SalesService {

  // API: 판매계획 정보 등록 메서드 //
  ResponseEntity<? super PutSalesPlanInfoResponseDto> putSalesPlanInfo(Integer employeeCode, PutSalesPlanInfoRequestDto dto);
  
  // API:
  ResponseEntity<? super GetSalesPlanListResponseDto> getSalesPlanList(Integer employeeCode, Integer salesPlanCode);

  // API: 판매계획 정보 상세 조회 메서드 //
  ResponseEntity<? super SalesPlanResponseDto> getSalesPlanDetail(Integer SalesPlanCode);

}
