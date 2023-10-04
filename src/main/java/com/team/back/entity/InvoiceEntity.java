package com.team.back.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.team.back.dto.request.accounting.GetInvoiceListRequestDto;

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
     private int productCode;
     private int customerCode;
     private int workerCode;
     private String productDetails;
     private String invoiceDate;
     private int invoiceType;
     private String customerName;
     private int price;
}
