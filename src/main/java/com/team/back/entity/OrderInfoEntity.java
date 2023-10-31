package com.team.back.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.team.back.dto.request.sales.PutOrderInfoRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="order_table")
@Table(name="order_table")
public class OrderInfoEntity {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int orderCode;
  private int salesPlanCode;
  private int customerCode;
  private String orderDate;
  private int managerCode;

  public OrderInfoEntity(PutOrderInfoRequestDto dto) {
    this.orderCode = dto.getOrderCode();
    this.salesPlanCode = dto.getSalesPlanCode();
    this.customerCode = dto.getCustomerCode();
    this.orderDate = dto.getOrderDate();
    this.managerCode = dto.getManagerCode();
  }
}
