package com.team.back.dto.response.system;

import java.util.List;

import com.team.back.dto.response.ResponseDto;
import com.team.back.entity.CustomerEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomerResponseDto extends ResponseDto {

  private String customerName;
  private String customerBusinessNumber;
  private String customerPostCode;
  private String customerAddress;
  private String customerAddressDetail;
  private String customerTelNumber;

  public CustomerResponseDto(String code, String message, CustomerEntity customerEntity) {
    super(code, message);
    this.customerName = customerEntity.getCustomerName();
    this.customerBusinessNumber = customerEntity.getCustomerBusinessNumber();
    this.customerPostCode = customerEntity.getCustomerPostCode();
    this.customerAddress = customerEntity.getCustomerAddress();
    this.customerAddressDetail = customerEntity.getCustomerAddressDetail();
    this.customerTelNumber = customerEntity.getCustomerTelNumber();
  }

  public CustomerResponseDto(CustomerEntity customerEntity) {
    this.customerName = customerEntity.getCustomerName();
    this.customerBusinessNumber = customerEntity.getCustomerBusinessNumber();
    this.customerPostCode = customerEntity.getCustomerPostCode();
    this.customerAddress = customerEntity.getCustomerAddress();
    this.customerAddressDetail = customerEntity.getCustomerAddressDetail();
    this.customerTelNumber = customerEntity.getCustomerTelNumber();
  }


}
