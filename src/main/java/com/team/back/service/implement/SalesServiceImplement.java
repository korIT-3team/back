package com.team.back.service.implement;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.back.common.constants.DepartmentCode;
import com.team.back.dto.request.sales.PutOrderInfoInfoRequestDto;
import com.team.back.dto.request.sales.PutReleaseInfoRequestDto;
import com.team.back.dto.request.sales.PutSalesPlanInfoRequestDto;
import com.team.back.dto.response.ResponseDto;
import com.team.back.dto.response.sales.PutSalesPlanInfoResponseDto;
import com.team.back.entity.SalesPlanEntity;
import com.team.back.repository.SalesPlanRepository;
import com.team.back.repository.UserRepository;
import com.team.back.repository.UserViewRepository;
import com.team.back.service.SalesService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SalesServiceImplement implements SalesService {

  private final SalesPlanRepository salesPlanRepository;
  private final UserRepository userRepository;
  private final UserViewRepository userViewRepository;
  
  @Override
  public ResponseEntity<? super PutSalesPlanInfoResponseDto> putSalesPlanInfo(String employeeCode, PutSalesPlanInfoRequestDto dto) {
    
    Integer emCode = Integer.parseInt(employeeCode);

    try {
      // description: 존재하는 사원번호인지 확인 //
      boolean hasUser = userRepository.existsByEmployeeCode(emCode);
      if(!hasUser) return PutSalesPlanInfoResponseDto.noExistedUser();

      // description: 권한 //
      Integer dpCode = userViewRepository.getUserDepartmentCode(emCode);
      if(!DepartmentCode.SYSTEM.equals(dpCode)) return PutSalesPlanInfoResponseDto.noPermission();

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

  @Override
  public ResponseEntity<?> putReleaseInfoInfo(Integer employeeCode, PutReleaseInfoRequestDto dto) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'putReleaseInfoInfo'");
  }

  @Override
  public ResponseEntity<?> deleteReleaseInfoInfo(Integer employeeCode, Integer deleteReleaseCode) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteReleaseInfoInfo'");
  }

  @Override
  public ResponseEntity<?> getReleaseInfoInfo(Integer employeeCode, Integer releaseCode, String releaseDate) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getReleaseInfoInfo'");
  }

  
}
