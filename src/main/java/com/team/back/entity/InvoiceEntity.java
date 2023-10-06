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
@Entity(name="invoice")
@Table(name="invoice")
public class InvoiceEntity {
     @Id
     private int invoiceCode;
     private int invoiceDetailPk;
     private String invoiceDate;
     private int invoiceType;
     private String workerName;
     private int workerCode;
     private int workerDepartmentCode;
     private int price;
     private String priceDetail;
}
