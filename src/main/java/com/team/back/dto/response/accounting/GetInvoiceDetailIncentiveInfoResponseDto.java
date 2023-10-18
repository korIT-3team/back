package com.team.back.dto.response.accounting;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.response.ResponseDto;
import com.team.back.entity.IncentiveViewEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetInvoiceDetailIncentiveInfoResponseDto extends ResponseDto {
     private Integer incentiveCode;
     private String incentiveCategoryName;
     private String paymentDate;
     private String employeeName;
     private double incentivePrice;
     private String content;

     public GetInvoiceDetailIncentiveInfoResponseDto(String code, String message, IncentiveViewEntity incentiveViewEntity){
          super(code, message);
          this.incentiveCode = incentiveViewEntity.getIncentiveCode();
          this.incentiveCategoryName = incentiveViewEntity.getIncentiveCategoryName();
          this.paymentDate = incentiveViewEntity.getPaymentDate();
          this.employeeName = incentiveViewEntity.getEmployeeName();
          this.incentivePrice = incentiveViewEntity.getIncentivePrice();
          this.content = incentiveViewEntity.getContent();
     }

     public static ResponseEntity<GetInvoiceDetailIncentiveInfoResponseDto> success(IncentiveViewEntity incentiveViewEntity) {
          GetInvoiceDetailIncentiveInfoResponseDto result = new GetInvoiceDetailIncentiveInfoResponseDto(ResponseCode.Success, ResponseMessage.Success, incentiveViewEntity);
          return ResponseEntity.status(HttpStatus.OK).body(result);
     }
     
     public static ResponseEntity<ResponseDto> noExistedInvoice() {
          ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_INVOICE, ResponseMessage.NO_EXISTED_INVOICE);
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
     }
}
