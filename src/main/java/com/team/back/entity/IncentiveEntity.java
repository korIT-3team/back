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
@Entity(name="incentive")
@Table(name="incentive")
public class IncentiveEntity {
  @Id
  private int  incentiveCode;
  private int  employeeCode;
  private int incentiveCategory;
  private String paymentDate;
  private Double incentivePrice;
  private String content;
}
