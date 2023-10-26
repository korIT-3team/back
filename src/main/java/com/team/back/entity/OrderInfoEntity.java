package com.team.back.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.team.back.dto.request.sales.PutOrderInfoInfoRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="order_information")
@Table(name="order_information")
public class OrderInfoEntity {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)

  private int orderCode;
  private int salesPlanCode;
  private int companyCode;
  private int customerCode;
  private String customerName;
  private String orderDate;
  private int managerCode;
  private String managerName;
  private String orderDetail;
  private int productCode;
  private String productName;
  private String orderUnit;
  private int orderQuantity;
  private double orderPrice;
  private double orderTotalPrice;

  public OrderInfoEntity(PutOrderInfoInfoRequestDto dto) {
  this.orderCode = dto.getOrderCodeInfo();
  this.salesPlanCode = dto.getOrderInfoSalesPlanCode();
  this.companyCode = dto.getOrderInfoCompanyCode();
  this.customerCode = dto.getOrderInfoCustomerCode();
  this.orderDate = dto.getOrderDate();
  this.managerCode = dto.getOrderInfoManagerCode();
  this.orderDetail = dto.getOrderDetail();
  this.productCode = dto.getOrderInfoproductCode();
  this.productName = dto.getOrderInfoProductName();
  this.orderUnit = dto.getOrderUnit();
  this.orderQuantity = dto.getOrderQuantity();
  this.orderPrice = dto.getOrderPrice();
  this.orderTotalPrice = dto.getOrderTotalPrice();
  }
}
