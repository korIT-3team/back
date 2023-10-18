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
@Entity(name = "sales_view")
@Table(name = "sales_view")
public class SalesViewEntity {
     @Id
     private Integer salesCode;
     private Integer salesPlanCode;
     private String projectName;
     private String deadlineDate;
     private String salesDetail;
     private Integer salesPrice;
     private String employeeName;
     private String customerName;
}
