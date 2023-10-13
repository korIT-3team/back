package com.team.back.dto.response.sales;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.response.ResponseDto;
import com.team.back.entity.SalesPlanEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SalesPlanResponseDto extends ResponseDto {

  private int salesPlanCode;
  private String projectName;
  private String planDate;
  private int productCode;
  private String productName;
  private int planQuantity;
  private int exchangeRateCode;
  private double exchangeRate;
  private double expectPrice;
  private double expectTotalPrice;
  private double expectKoreanPrice;

  public SalesPlanResponseDto(String code, String message, SalesPlanEntity salesPlanEntity) {
    super(code, message);
    this.salesPlanCode = salesPlanEntity.getSalesPlanCode();
    this.projectName = salesPlanEntity.getProjectName();
    this.planDate = salesPlanEntity.getPlanDate();
    this.productCode = salesPlanEntity.getProductCode();
    this.productName = salesPlanEntity.getProductName();
    this.planQuantity = salesPlanEntity.getPlanQuantity();
    this.exchangeRateCode = salesPlanEntity.getExchangeRateCode();
    this.exchangeRate = salesPlanEntity.getExchangeRate();
    this.expectPrice = salesPlanEntity.getExpectPrice();
    this.expectTotalPrice = salesPlanEntity.getExpectTotalPrice();
    this.expectKoreanPrice = salesPlanEntity.getExpectKoreanPrice();
  }

  public SalesPlanResponseDto(SalesPlanEntity salesPlanEntity) {

    this.salesPlanCode = salesPlanEntity.getSalesPlanCode();
    this.projectName = salesPlanEntity.getProjectName();
    this.planDate = salesPlanEntity.getPlanDate();
    this.productCode = salesPlanEntity.getProductCode();
    this.productName = salesPlanEntity.getProductName();
    this.planQuantity = salesPlanEntity.getPlanQuantity();
    this.exchangeRateCode = salesPlanEntity.getExchangeRateCode();
    this.exchangeRate = salesPlanEntity.getExchangeRate();
    this.expectPrice = salesPlanEntity.getExpectPrice();
    this.expectTotalPrice = salesPlanEntity.getExpectTotalPrice();
    this.expectKoreanPrice = salesPlanEntity.getExpectKoreanPrice();

  }

  public static List<SalesPlanResponseDto> copyEntityList(List<SalesPlanEntity> salesPlanEntities) {
    List<SalesPlanResponseDto> salesPlanList = new ArrayList<>();

    for(SalesPlanEntity salesPlanEntity: salesPlanEntities) {
      SalesPlanResponseDto salesPlanItem = new SalesPlanResponseDto(salesPlanEntity);
      salesPlanList.add(salesPlanItem); 
    }

    return salesPlanList;
  }

  public static ResponseEntity<SalesPlanResponseDto> success(SalesPlanEntity salesPlanEntity) {
    SalesPlanResponseDto result = new SalesPlanResponseDto(ResponseCode.Success, ResponseMessage.Success, salesPlanEntity);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  public static ResponseEntity<ResponseDto> noExistedSalesPlan() {
    ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_SALES_PLAN, ResponseMessage.NO_EXISTED_SALE_PLAN);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }

  
}
