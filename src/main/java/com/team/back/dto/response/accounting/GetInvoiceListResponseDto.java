package com.team.back.dto.response.accounting;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.response.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetInvoiceListResponseDto extends ResponseDto {

     private List<InvoiceResponseDto> invoiceList;

     private GetInvoiceListResponseDto(String code, String message, List<InvoiceResponseDto> invoiceList) {
          super(code, message);
          this.invoiceList = invoiceList;
     }

     public static ResponseEntity<GetInvoiceListResponseDto> success(List<InvoiceResponseDto> invoiceList) {
          GetInvoiceListResponseDto result = new GetInvoiceListResponseDto(ResponseCode.Success, ResponseMessage.Success, invoiceList);
          return ResponseEntity.status(HttpStatus.OK).body(result);
     }
}
