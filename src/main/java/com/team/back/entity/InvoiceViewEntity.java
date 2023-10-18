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
@Entity(name="invoice_view")
@Table(name="invoice_view")
public class InvoiceViewEntity {
     @Id
     private int invoiceCode;
     private int invoiceDetailPk;
     private String invoiceDate;
     private String invoiceTypeName;
     private String workerName;
     private double price;
     private String priceDetail;
}
