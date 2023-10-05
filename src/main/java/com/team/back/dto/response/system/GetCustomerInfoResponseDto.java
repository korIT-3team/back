package com.team.back.dto.response.system;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.response.ResponseDto;
import com.team.back.entity.CustomerEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetCustomerInfoResponseDto extends ResponseDto {

  private int companyCode;
  private int customerCode;
  private String customerName;
  private String businessNumber;
  private String postCode;
  private String customerAddress;
  private String customerAddressDetail;
  private String customerTelNumber;

  private GetCustomerInfoResponseDto(String code, String message, CustomerEntity customerEntity) {
    super(code, message);
    this.companyCode = customerEntity.getCompanyCode();
    this.customerCode = customerEntity.getCustomerCode();
    this.customerName = customerEntity.getCustomerName();
    this.businessNumber = customerEntity.getBusinessNumber();
    this.postCode = customerEntity.getPostCode();
    this.customerAddress = customerEntity.getCustomerAddress();
    this.customerAddressDetail = customerEntity.getCustomerAddressDetail();
    this.customerTelNumber = customerEntity.getCustomerTelNumber();
  }

  public static ResponseEntity<GetCustomerInfoResponseDto> success(CustomerEntity customerEntity) {
    GetCustomerInfoResponseDto result = new GetCustomerInfoResponseDto(ResponseCode.Success, ResponseMessage.Success, customerEntity);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  public static ResponseEntity<ResponseDto> noExistedCustomerInfo() {
    ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_CUSTOMER_INFO, ResponseMessage.NO_EXISTED_CUSTOMER_INFO);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }
  
}
