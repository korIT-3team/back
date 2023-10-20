package com.team.back.service.implement;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.back.dto.request.sales.PutOrderInfoInfoRequestDto;
import com.team.back.dto.request.sales.PutSalesPlanInfoRequestDto;
import com.team.back.dto.response.ResponseDto;
import com.team.back.dto.response.sales.PutSalesPlanInfoResponseDto;
import com.team.back.dto.response.sales.SalesPlanListResponseDto;
import com.team.back.dto.response.system.PutCompanyInfoResponseDto;
import com.team.back.entity.SalesPlanEntity;
import com.team.back.entity.resultSets.SalesPlanListResultSet;
import com.team.back.repository.SalesPlanRepository;
import com.team.back.repository.UserRepository;
import com.team.back.service.SalesService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SalesServiceImplement implements SalesService {

  private final SalesPlanRepository salesPlanRepository;
  private final UserRepository userRepository;
  
  @Override
  public ResponseEntity<? super PutSalesPlanInfoResponseDto> putSalesPlanInfo(Integer employeeCode, PutSalesPlanInfoRequestDto dto) {

    try {
      // description: 존재하는 사원번호인지 확인 //
      boolean hasUser = userRepository.existsByEmployeeCode(employeeCode);
      if(!hasUser) return PutSalesPlanInfoResponseDto.noExistedUser();

      // description: 권한 //
      if(employeeCode != 9999) return PutSalesPlanInfoResponseDto.noPermission();

      // description: entity 생성 //
      SalesPlanEntity salesPlanEntity = new SalesPlanEntity(dto);

      // description: 데이터베이스에 저장 //
      salesPlanRepository.save(salesPlanEntity);

    } catch (Exception exception) {
      exception.printStackTrace();;
      return ResponseDto.databaseError();
    }
    return PutSalesPlanInfoResponseDto.success();
    
  }

  @Override
  public ResponseEntity<?> deleteSalesPlanInfo(Integer employeeCode, Integer deleteSalesPlanCode) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteSalesPlanInfo'");
  }

  @Override
  public ResponseEntity<?> getSalesPlanInfo(Integer employeeCode, Integer salesPlanCode, String projectName) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getSalesPlanInfo'");
  }

  @Override
  public ResponseEntity<?> putOrderInfoInfo(Integer employeeCode, PutOrderInfoInfoRequestDto dto) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'putOrderInfoInfo'");
  }

  
}
