package com.team.back.dto.response.accounting;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.response.ResponseDto;
import com.team.back.entity.SalesViewEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetInvoiceDetailSalesInfoResponseDto extends ResponseDto {
     private Integer salesCode;
     private Integer salesPlanCode;
     private String projectName;
     private String deadlineDate;
     private String salesDetail;
     private Integer salesPrice;
     private String employeeName;
     private String customerName;

     public GetInvoiceDetailSalesInfoResponseDto(String code, String message, SalesViewEntity salesViewEntity){
          super(code, message);
          this.salesCode = salesViewEntity.getSalesCode();
          this.salesPlanCode = salesViewEntity.getSalesPlanCode();
          this.projectName = salesViewEntity.getProjectName();
          this.deadlineDate = salesViewEntity.getDeadlineDate();
          this.salesDetail = salesViewEntity.getSalesDetail();
          this.salesPrice = salesViewEntity.getSalesPrice();
          this.employeeName = salesViewEntity.getEmployeeName();
          this.customerName = salesViewEntity.getCustomerName();
     }
     public static ResponseEntity<GetInvoiceDetailSalesInfoResponseDto> success(SalesViewEntity salesViewEntity) {
          GetInvoiceDetailSalesInfoResponseDto result = new GetInvoiceDetailSalesInfoResponseDto(ResponseCode.Success, ResponseMessage.Success, salesViewEntity);
          return ResponseEntity.status(HttpStatus.OK).body(result);
     }
     
     public static ResponseEntity<ResponseDto> noExistedInvoice() {
          ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_INVOICE, ResponseMessage.NO_EXISTED_INVOICE);
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
     }
}
