package com.team.back.service.implement;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.back.dto.request.sales.GetSalesPlanListRequestDto;
import com.team.back.dto.request.sales.PutSalesPlanInfoRequestDto;
import com.team.back.dto.response.ResponseDto;
import com.team.back.dto.response.sales.GetSalesPlanListResponseDto;
import com.team.back.dto.response.sales.PutSalesPlanInfoResponseDto;
import com.team.back.dto.response.sales.SalesPlanResponseDto;
import com.team.back.dto.response.system.PutCompanyInfoResponseDto;
import com.team.back.entity.SalesPlanEntity;
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
  public ResponseEntity<? super GetSalesPlanListResponseDto> getSalesPlanList(GetSalesPlanListRequestDto dto) {
    List<SalesPlanResponseDto> salesPlanList = null;
    
    Integer deptCode = dto.getDepartmentCode();
    Integer empCode = dto.getEmployeeCode();
    String pDate = dto.getPlanDate();
    Integer proCode = dto.getProductCode();
    String proName = dto.getProductName();
    Integer pQuantity = dto.getPlanQuantity();
    Integer exType = dto.getExchangeType();
    Double exRate = dto.getExchangeRate();
    Double exPrice = dto.getExpectPrice();
    Double exTotalPrice = dto.getExpectTotalPrice();

    try {

      // description : string으로 변환시키지않으면, "null" 문자열이 들어가게 된다.
      String strDeptCode = deptCode == null ? "" : Integer.toString(deptCode);
      String strEmpCode = empCode == null ? "" : Integer.toString(empCode);
      String strProCode = proCode == null ? "" : Integer.toString(proCode);
      String strPQuantity = pQuantity == null ? "" : Integer.toString(pQuantity);
      String strExType = exType == null ? "" : Integer.toString(exType);
      String strExRate = exRate == null ? "" : Double.toString(exRate);
      String strExPrice = exPrice == null ? "" : Double.toString(exPrice);
      String strExTotalPrice = exTotalPrice == null ? "" : Double.toString(exTotalPrice);

      // description : db 조회
      List<SalesPlanEntity> salesPlanEntities = salesPlanRepository.getSalesPlanList(strDeptCode, strEmpCode, pDate, strProCode, strExType, strPQuantity, strExRate, pDate, strExPrice, strExTotalPrice);

      // description : entity 를 dto 로 변환 //
      salesPlanList = SalesPlanResponseDto.copyEntityList(salesPlanEntities);

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
