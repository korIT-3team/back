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
@Entity(name="funds_view")
@Table(name="funds_view")
public class FundsViewEntity {
     @Id
     private int fundingCode;
     private String fundDate;
     private int salesPlanCode;
     private String customerName;
     private double price;
     private String priceDetail;
     private int taxType;
     private double fundBalance;
}
