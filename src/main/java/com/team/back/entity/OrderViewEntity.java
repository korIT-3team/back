package com.team.back.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "order_view")
@Table(name = "order_view")
public class OrderViewEntity {
     @Id
     private Integer orderCode;
     private String orderDate;
     private Double orderPrice;
     private String orderDetail;
     private Integer salesPlanCode;
     private Integer customerCode;
     private String employeeName;
     private String customerName;
}
