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
public class GetInvoiceTypeListResponseDto extends ResponseDto  {
private List<InvoiceTypeResponseDto> invoiceTypeList;

     public GetInvoiceTypeListResponseDto(String code, String message, List<InvoiceTypeResponseDto> invoiceTypeList){
          super(code, message);
          this.invoiceTypeList = invoiceTypeList;
     }
     
     public static ResponseEntity<GetInvoiceTypeListResponseDto> success(List<InvoiceTypeResponseDto> invoiceTypeList) {
          GetInvoiceTypeListResponseDto result = new GetInvoiceTypeListResponseDto(ResponseCode.Success, ResponseMessage.Success, invoiceTypeList);
          return ResponseEntity.status(HttpStatus.OK).body(result);
     }
}
