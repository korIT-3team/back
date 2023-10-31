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
  private int productCode;
  private String planDate;
  private int planQuantity;
  private double expectPrice;
  private double expectTotalPrice;
  private int employeeCode;

  public SalesPlanEntity(PutSalesPlanInfoRequestDto dto) {
    this.salesPlanCode = dto.getSalesPlanCodeInfo();
    this.projectName = dto.getSalesPlanProjectName();
    this.planDate = dto.getSalesPlanDate();
    this.productCode = dto.getSalesPlanProductCodeInfo();
    this.planQuantity = dto.getSalesPlanQuantity();
    this.expectPrice = dto.getSalesPlanExpectPrice();
    this.expectTotalPrice = dto.getSalesPlanExpectTotalPrice();
    this.employeeCode = dto.getSalesPlanEmployeeCodeInfo();
  }
}