package com.team.back.service.implement;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.back.dto.request.sales.PutSalesPlanInfoRequestDto;
import com.team.back.dto.response.ResponseDto;
import com.team.back.dto.response.sales.GetSalesPlanListResponseDto;
import com.team.back.dto.response.sales.PutSalesPlanInfoResponseDto;
import com.team.back.dto.response.sales.SalesPlanListResponseDto;
import com.team.back.dto.response.sales.SalesPlanResponseDto;
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
  public ResponseEntity<? super GetSalesPlanListResponseDto> getSalesPlanList(Integer employeeCode, Integer salesPlanCode) {
    List<SalesPlanListResponseDto> salesPlanList = null;

    try {

      salesPlanCode = salesPlanCode == null ? null : salesPlanCode;
      // description: 검색어가 판매계획코드에 포함되어 있는 데이터 조회 //
      List<SalesPlanListResultSet> salesPlanEntities = salesPlanRepository.getSalesPlanList(salesPlanCode);

      // description: entity를 dto형태로 변환 //
      salesPlanList = SalesPlanListResponseDto.copyList(salesPlanEntities);

    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return GetSalesPlanListResponseDto.success(salesPlanList);

  }

  @Override
  public ResponseEntity<? super SalesPlanResponseDto> getSalesPlanDetail(Integer SalesPlanCode) {

    SalesPlanEntity salesPlanEntity;
    try {
      // description : 선택된 해당 판매계획코드의 데이터를 가져옴 //
      salesPlanEntity = salesPlanRepository.findBySalesPlanCode(SalesPlanCode);
      if (salesPlanEntity == null) return SalesPlanResponseDto.noExistedSalesPlan();
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    return SalesPlanResponseDto.success(salesPlanEntity);
  }
  
  
}
