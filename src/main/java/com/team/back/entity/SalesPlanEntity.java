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
    this.projectName = dto.getProjectNameInfo();
    this.employeeCode = dto.getEmployeeCodeInfo();
    this.departmentCode = dto.getDepartmentCodeInfo();
    this.companyCode = dto.getSalesPlanCompanyCode();
    this.planDate = dto.getPlanDate();
    this.productCode = dto.getProductCode();
    this.productName = dto.getProductName();
    this.planQuantity = dto.getPlanQuantity();
    this.exchangeRateCode = dto.getExchangeRateCode();
    this.exchangeRate = dto.getExchangeRate();
    this.expectPrice = dto.getExpectPrice();
    this.expectTotalPrice = dto.getExpectTotalPrice();
    this.expectKoreanPrice = dto.getExpectKoreanPrice();
  }

  
}
