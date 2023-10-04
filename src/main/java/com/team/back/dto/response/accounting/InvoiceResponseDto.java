package com.team.back.dto.response.accounting;

import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.InvoiceEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InvoiceResponseDto {
     private int invoiceCode;
     private int productCode;
     private int customerCode;
     private int workerCode;
     private String productDetails;
     private String invoiceDate;
     private int invoiceType;
     private String customerName;
     private int price;

     public InvoiceResponseDto(InvoiceEntity invoiceEntity) {
          this.invoiceCode = invoiceEntity.getInvoiceCode();
          this.productCode = invoiceEntity.getProductCode();
          this.customerCode = invoiceEntity.getCustomerCode();
          this.workerCode = invoiceEntity.getWorkerCode();
          this.productDetails = invoiceEntity.getProductDetails();
          this.invoiceDate = invoiceEntity.getInvoiceDate();
          this.invoiceType = invoiceEntity.getInvoiceType();
          this.customerName = invoiceEntity.getCustomerName();
          this.price = invoiceEntity.getPrice();
     }

     public static List<InvoiceResponseDto> copyEntityList(List<InvoiceEntity> invoiceEntities) {
          List<InvoiceResponseDto> invoiceList = new ArrayList<>();

          for(InvoiceEntity invoiEntity: invoiceEntities) {
               InvoiceResponseDto invoiceItem = new InvoiceResponseDto(invoiEntity);
               invoiceList.add(invoiceItem);
          }

          return invoiceList;
     }
}
