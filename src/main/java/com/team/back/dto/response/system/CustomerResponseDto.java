package com.team.back.dto.response.system;

import java.util.List;

import com.team.back.dto.response.ResponseDto;
import com.team.back.entity.CustomerEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomerResponseDto extends ResponseDto {

  private int companyCode;
  private int customerCode;
  private String customerName;
  private String businessNumber;
  private String customerPostCode;
  private String customerAddress;
  private String customerAddressDetail;
  private String customerTelNumber;

  public CustomerResponseDto(String code, String message, CustomerEntity customerEntity) {
    super(code, message);
    this.companyCode = customerEntity.getCompanyCode();
    this.customerCode = customerEntity.getCustomerCode();
    this.customerName = customerEntity.getCustomerName();
    this.businessNumber = customerEntity.getCustomerBusinessNumber();
    this.customerPostCode = customerEntity.getCustomerPostCode();
    this.customerAddress = customerEntity.getCustomerAddress();
    this.customerAddressDetail = customerEntity.getCustomerAddressDetail();
    this.customerTelNumber = customerEntity.getCustomerTelNumber();
  }

  public CustomerResponseDto(CustomerEntity customerEntity) {
    this.companyCode = customerEntity.getCompanyCode();
    this.customerCode = customerEntity.getCustomerCode();
    this.customerName = customerEntity.getCustomerName();
    this.businessNumber = customerEntity.getCustomerBusinessNumber();
    this.customerPostCode = customerEntity.getCustomerPostCode();
    this.customerAddress = customerEntity.getCustomerAddress();
    this.customerAddressDetail = customerEntity.getCustomerAddressDetail();
    this.customerTelNumber = customerEntity.getCustomerTelNumber();
  }


}
