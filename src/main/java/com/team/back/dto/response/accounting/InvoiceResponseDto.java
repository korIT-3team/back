package com.team.back.dto.response.accounting;

import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.InvoiceViewEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InvoiceResponseDto {
     private int invoiceCode;
     private int invoiceDetailPk;
     private String invoiceDate;
     private String invoiceTypeName;
     private String workerName;
     private double price;
     private String priceDetail;
     
     public InvoiceResponseDto(InvoiceViewEntity invoiceViewEntity) {
          this.invoiceCode = invoiceViewEntity.getInvoiceCode();
          this.workerName = invoiceViewEntity.getWorkerName();
          this.invoiceDate = invoiceViewEntity.getInvoiceDate();
          this.invoiceTypeName = invoiceViewEntity.getInvoiceTypeName();
          this.invoiceDetailPk = invoiceViewEntity.getInvoiceDetailPk();
          this.price = invoiceViewEntity.getPrice();
          this.priceDetail = invoiceViewEntity.getPriceDetail();
     }

     public static List<InvoiceResponseDto> copyEntityList(List<InvoiceViewEntity> invoiceViewEntities) {
          List<InvoiceResponseDto> invoiceList = new ArrayList<>();

          for(InvoiceViewEntity invoiEntity: invoiceViewEntities) {
               InvoiceResponseDto invoiceItem = new InvoiceResponseDto(invoiEntity);
               invoiceList.add(invoiceItem);
          }

          return invoiceList;
     }
}
