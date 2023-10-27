package com.team.back.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.team.back.dto.request.sales.PutSalesPlanInfoRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="sales_plan")
@Table(name="sales_plan")
public class SalesPlanEntity {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int salesPlanCode;
  private String projectName;
  private int employeeCode;
  private int departmentCode;
  private int companyCode;
  private String planDate;
  private int productCode;
  private String productName;
  private int planQuantity;
  private int exchangeRateCode;
  private double exchangeRate;
  private double expectPrice;
  private double expectTotalPrice;
  private double expectKoreanPrice;

  public SalesPlanEntity(PutSalesPlanInfoRequestDto dto) {
    this.salesPlanCode = dto.getSalesPlanCodeInfo();
    this.projectName = dto.getSalesPlanProjectName();
    this.employeeCode = dto.getSalesPlanEmployeeCodeInfo();
    this.departmentCode = dto.getSalesPlanDepartmentCodeInfo();
    this.companyCode = dto.getSalesPlanCompanyCodeInfo();
    this.planDate = dto.getSalesPlanDate();
    this.productCode = dto.getSalesPlanProductCodeInfo();
    this.productName = dto.getSalesPlanProductNameInfo();
    this.planQuantity = dto.getSalesPlanQuantity();
    this.exchangeRateCode = dto.getSalesPlanExchangeRateCode();
    this.exchangeRate = dto.getSalesPlanExchangeRate();
    this.expectPrice = dto.getSalesPlanExpectPrice();
    this.expectTotalPrice = dto.getSalesPlanExpectTotalPrice();
    this.expectKoreanPrice = dto.getSalesPlanExpectKoreanPrice();
  }

  
}
