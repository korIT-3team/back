package com.team.back.dto.response.system;

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
public class GetCustomerInfoResponseDto extends ResponseDto {

  private List<CustomerListResponseDto> customerList;

  private GetCustomerInfoResponseDto(String code, String message, List<CustomerListResponseDto> customerList) {
    super(code, message);
    this.customerList = customerList;
  }

  public static ResponseEntity<GetCustomerInfoResponseDto> success(List<CustomerListResponseDto> customerList) {
    GetCustomerInfoResponseDto result = new GetCustomerInfoResponseDto(ResponseCode.Success, ResponseMessage.Success, customerList);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  public static ResponseEntity<ResponseDto> noExistedCustomerInfo() {
    ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_CUSTOMER_INFO, ResponseMessage.NO_EXISTED_CUSTOMER_INFO);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }
  
}
