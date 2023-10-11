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
@Entity(name="inout_come_view")
@Table(name="inout_come_view")
public class InOutComeViewEntity {
     @Id
     private int fundingCode;
     private String fundDate;
     private int salesPlanCode;
     private String customerName;
     private double price;
     private String priceDetail;
     private String taxType;
     private String fundBalance;
}
