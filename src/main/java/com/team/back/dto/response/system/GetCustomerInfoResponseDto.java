package com.team.back.dto.response.system;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.response.ResponseDto;
import com.team.back.entity.CustomerEntity;


public class GetCustomerInfoResponseDto extends ResponseDto {
  private List<CustomerListResponseDto> customerList;

  // private int no;
  // private int companyCode;
  // private int customerCode;
  // private String customerName;
  // private String businessNumber;
  // private String customerAddress;
  // private String customerAddressDetail;
  // private String customerTelNumber;

  private GetCustomerInfoResponseDto(String code, String message, List<CustomerListResponseDto> customerList) {
    super(code, message);
    this.customerList = customerList;
    // this.companyCode = customerEntity.getCompanyCode();
    // this.customerCode = customerEntity.getCustomerCode();
    // this.customerName = customerEntity.getCustomerName();
    // this.businessNumber = customerEntity.getBusinessNumber();
    // this.customerAddress = customerEntity.getCustomerAddress();
    // this.customerAddressDetail = customerEntity.getCustomerAddressDetail();
    // this.customerTelNumber = customerEntity.getCustomerTelNumber();
  }

  public static ResponseEntity<GetCustomerInfoResponseDto> success(List<CustomerListResponseDto> customerList) {
    GetCustomerInfoResponseDto result = new GetCustomerInfoResponseDto(ResponseCode.Success, ResponseMessage.Success, customerList);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  // public static ResponseEntity<GetCustomerInfoResponseDto> success(CustomerEntity customerEntity) {
  //   GetCustomerInfoResponseDto result = new GetCustomerInfoResponseDto(ResponseCode.Success, ResponseMessage.Success, customerEntity);
  //   return ResponseEntity.status(HttpStatus.OK).body(result);
  // }

  // public static ResponseEntity<ResponseDto> noExistedCustomerInfo() {
  //   ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_CUSTOMER_INFO, ResponseMessage.NO_EXISTED_CUSTOMER_INFO);
  //   return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  // }
  
}
