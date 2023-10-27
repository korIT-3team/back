package com.team.back.dto.response.sales;

import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.resultSets.SalesPlanListResultSet;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SalesPlanListResponseDto {

  private int no;
  private int salesPlanCode;
  private String projectName;
  private int departmentCode;
  private String departmentName;
  private int employeeCode;
  private String employeeName;
  private int companyCode;
  private String planDate;
  private int productCode;
  private String productName;
  private String unit;
  private int planQuantity;
  private int exchangeRateCode;
  private double exchangeRate;
  private double expectPrice;
  private double expectTotalPrice;
  private double expectKoreanPrice;

  public SalesPlanListResponseDto (SalesPlanListResultSet resultSet) {
    this.no = resultSet.getNo();
    this.salesPlanCode = resultSet.getSalesPlanCode();
    this.projectName = resultSet.getProjectName();
    this.employeeCode = resultSet.getEmployeeCode();
    this.departmentCode = resultSet.getDepartmentCode();
    this.companyCode = resultSet.getCompanyCode();
    this.planDate = resultSet.getPlanDate();
    this.productCode = resultSet.getProductCode();
    this.planQuantity = resultSet.getPlanQuantity();
    this.exchangeRateCode = resultSet.getExchangeRateCode();
    this.exchangeRate = resultSet.getExchangeRate();
    this.expectPrice = resultSet.getExpectPrice();
    this.expectTotalPrice = resultSet.getExpectTotalPrice();
    this.expectKoreanPrice = resultSet.getExpectKoreanPrice();
  }

  public static List<SalesPlanListResponseDto> copyList(List<SalesPlanListResultSet> resultSets) {
    List<SalesPlanListResponseDto> salesPlanList = new ArrayList<>();

    for (SalesPlanListResultSet resultSet: resultSets) {
      SalesPlanListResponseDto salesPlan = new SalesPlanListResponseDto(resultSet);
      salesPlanList.add(salesPlan);
    }

    return salesPlanList;
  }
  
}
