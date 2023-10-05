package com.team.back.dto.response.accounting;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.response.ResponseDto;
import com.team.back.dto.response.system.GetCompanyInfoResponseDto;
import com.team.back.entity.CompanyEntity;
import com.team.back.entity.InvoiceEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InvoiceResponseDto extends ResponseDto {
     private int invoiceCode;
     private int productCode;
     private int customerCode;
     private int workerCode;
     private int workerDepartmentCode;
     private String productDetails;
     private String invoiceDate;
     private int invoiceType;
     private String customerName;
     private int price;
     
     public InvoiceResponseDto(String code, String message, InvoiceEntity invoiceEntity) {
          super(code, message);
          this.invoiceCode = invoiceEntity.getInvoiceCode();
          this.productCode = invoiceEntity.getProductCode();
          this.customerCode = invoiceEntity.getCustomerCode();
          this.workerCode = invoiceEntity.getWorkerCode();
          this.workerDepartmentCode = invoiceEntity.getWorkerDepartmentCode();
          this.productDetails = invoiceEntity.getProductDetails();
          this.invoiceDate = invoiceEntity.getInvoiceDate();
          this.invoiceType = invoiceEntity.getInvoiceType();
          this.customerName = invoiceEntity.getCustomerName();
          this.price = invoiceEntity.getPrice();
     }

     public InvoiceResponseDto(InvoiceEntity invoiceEntity) {
          this.invoiceCode = invoiceEntity.getInvoiceCode();
          this.productCode = invoiceEntity.getProductCode();
          this.customerCode = invoiceEntity.getCustomerCode();
          this.workerCode = invoiceEntity.getWorkerCode();
          this.workerDepartmentCode = invoiceEntity.getWorkerDepartmentCode();
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

     public static ResponseEntity<InvoiceResponseDto> success(InvoiceEntity invoiceEntity) {
          InvoiceResponseDto result = new InvoiceResponseDto(ResponseCode.Success, ResponseMessage.Success, invoiceEntity);
          return ResponseEntity.status(HttpStatus.OK).body(result);
     }
     
     public static ResponseEntity<ResponseDto> noExistedInvoice() {
          ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_INVOICE, ResponseMessage.NO_EXISTED_INVOICE);
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
     }
}
