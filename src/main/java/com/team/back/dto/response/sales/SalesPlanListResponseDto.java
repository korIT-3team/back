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
  private String planDate;
  private int productCode;
  private String productName;
  private int planQuantity;
  private double expectPrice;
  private double expectTotalPrice;
  private int employeeCode;
  private String employeeName;

  public SalesPlanListResponseDto (SalesPlanListResultSet resultSet) {
    this.no = resultSet.getNo();
    this.salesPlanCode = resultSet.getSalesPlanCode();
    this.projectName = resultSet.getProjectName();
    this.planDate = resultSet.getPlanDate();
    this.productCode = resultSet.getProductCode();
    this.productName = resultSet.getProductName();
    this.planQuantity = resultSet.getPlanQuantity();
    this.expectPrice = resultSet.getExpectPrice();
    this.expectTotalPrice = resultSet.getExpectTotalPrice();
    this.employeeCode = resultSet.getEmployeeCode();
    this.employeeName = resultSet.getEmployeeName();
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
