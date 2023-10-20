package com.team.back.service;

import org.springframework.http.ResponseEntity;

import com.team.back.dto.request.sales.PutOrderInfoInfoRequestDto;
import com.team.back.dto.request.sales.PutSalesPlanInfoRequestDto;
import com.team.back.dto.response.sales.PutSalesPlanInfoResponseDto;

public interface SalesService {

  // API: 판매계획 정보 등록 메서드 //
  ResponseEntity<? super PutSalesPlanInfoResponseDto> putSalesPlanInfo(Integer employeeCode, PutSalesPlanInfoRequestDto dto);
  
  // API: 판매계획 정보 삭제 메서드 //
  ResponseEntity<?> deleteSalesPlanInfo(Integer employeeCode, Integer deleteSalesPlanCode);

  // API: 판매계획 정보 불러오기 메서드 //
  ResponseEntity<?> getSalesPlanInfo(Integer employeeCode, Integer salesPlanCode, String projectName);

//------------------------------------------------------------

  // API: 수주 정보 등록 메서드 //
  ResponseEntity<?> putOrderInfoInfo(Integer employeeCode, PutOrderInfoInfoRequestDto dto);

  // API: 수주 정보 삭제 메서드 //

  // API: 수주 정보 불러오기 메서드 //

//------------------------------------------------------------

  // API: 출고 정보 등록 메서드 //

  // API: 출고 정보 삭제 메서드 //

  // API: 출고 정보 불러오기 메서드 //

//------------------------------------------------------------

  // API: 매출 정보 등록 메서드 //

  // API: 매출 정보 삭제 메서드 //

  // API: 매출 정보 불러오기 메서드 //

}
