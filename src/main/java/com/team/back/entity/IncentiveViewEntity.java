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
@Entity(name = "incentive_view")
@Table(name = "incentive_view")
public class IncentiveViewEntity {
     @Id
     private Integer incentiveCode;
     private String employeeName;
     private String incentiveCategoryName;
     private String paymentDate;
     private double incentivePrice;
     private String content;
}
