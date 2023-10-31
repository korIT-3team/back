package com.team.back.service.implement;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.back.common.constants.DepartmentCode;
import com.team.back.dto.request.sales.PutOrderInfoRequestDto;
import com.team.back.dto.request.sales.PutReleaseInfoRequestDto;
import com.team.back.dto.request.sales.PutSalesPlanInfoRequestDto;
import com.team.back.dto.response.ResponseDto;
import com.team.back.dto.response.sales.DeleteSalesPlanInfoResponseDto;
import com.team.back.dto.response.sales.GetSalesPlanInfoResponseDto;
import com.team.back.dto.response.sales.PutOrderInfoResponseDto;
import com.team.back.dto.response.sales.PutSalesPlanInfoResponseDto;
import com.team.back.entity.OrderInfoEntity;
import com.team.back.entity.SalesPlanEntity;
import com.team.back.repository.OrderInfoRepository;
import com.team.back.dto.response.sales.SalesPlanListResponseDto;
import com.team.back.entity.resultSets.SalesPlanListResultSet;
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
  private final OrderInfoRepository orderInfoRepository;
  
  @Override
  public ResponseEntity<? super PutSalesPlanInfoResponseDto> putSalesPlanInfo(String employeeCode, PutSalesPlanInfoRequestDto dto) {
    
    Integer emCode = Integer.parseInt(employeeCode);

    int salesPlanCode = dto.getSalesPlanCodeInfo();
    String projectName = dto.getSalesPlanProjectName();
    
    try {

      // description: 신규입력의 경우
      if (salesPlanCode == 0) {
        // description: projectName 중복 확인
        boolean hasProjectName = salesPlanRepository.existsByProjectName(projectName);
        if (hasProjectName) return PutSalesPlanInfoResponseDto.existedProjectName();
      }

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

  @Override
  public ResponseEntity<? super PutOrderInfoResponseDto> putOrderInfo(String employeeCode, PutOrderInfoRequestDto requestBody) {
    Integer emCode = Integer.parseInt(employeeCode);
    try{
      // description: 존재하는 사원번호인지 확인 //
      boolean hasUser = userRepository.existsByEmployeeCode(emCode);
      if(!hasUser) return PutOrderInfoResponseDto.noExistedUser();
      // description: 권한 //
      Integer dpCode = userViewRepository.getUserDepartmentCode(emCode);
      if(!DepartmentCode.SYSTEM.equals(dpCode)) return PutOrderInfoResponseDto.noPermission();

      // description: entity 생성 //
      OrderInfoEntity orderInfoEntity = new OrderInfoEntity(requestBody);
      
      // description: 데이터베이스에 저장 //
      orderInfoRepository.save(orderInfoEntity);
    } catch(Exception exception){
          exception.printStackTrace();
          return ResponseDto.databaseError();
    }

    return PutOrderInfoResponseDto.success();
  }

  @Override
  public ResponseEntity<? super DeleteSalesPlanInfoResponseDto> deleteSalesPlanInfo(String employeeCode, Integer deleteSalesPlanCode) {
    
    Integer emCode = Integer.parseInt(employeeCode);

    try {
      // description: 존재하는 유저인지 확인 //
      boolean hasUser = userRepository.existsByEmployeeCode(emCode);
      if (!hasUser) return DeleteSalesPlanInfoResponseDto.noExistedUser();
      // description: 존재하는 salesPlanCode인지 확인 //
      SalesPlanEntity salesPlanEntity = salesPlanRepository.findBySalesPlanCode(deleteSalesPlanCode);
      if (salesPlanEntity == null) return DeleteSalesPlanInfoResponseDto.noExistSalesPlanInfo();
      // description: salesPlan 삭제 //
      salesPlanRepository.delete(salesPlanEntity);
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return DeleteSalesPlanInfoResponseDto.success();

  }

  @Override
  public ResponseEntity<? super GetSalesPlanInfoResponseDto> getSalesPlanInfo(String employeeCode, String projectName) {
    
    List<SalesPlanListResponseDto> salePlanList = null;

    try {
      projectName = projectName == null ? "" : projectName;
      // description: 검색어가 프로젝트명에 포함되어 있는 데이터 조회 //
      List<SalesPlanListResultSet> salesPlanEntities = salesPlanRepository.getSalesPlanList(projectName);

      // description: entity를 dto형태로 변환 //
      salePlanList = SalesPlanListResponseDto.copyList(salesPlanEntities);

    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    
    return GetSalesPlanInfoResponseDto.success(salePlanList);

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
