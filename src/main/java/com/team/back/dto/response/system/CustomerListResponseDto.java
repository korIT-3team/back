package com.team.back.dto.response.system;

import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.resultSets.CustomerListResultSet;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomerListResponseDto {

  private int no;
  private int companyCode;
  private int customerCode;
  private String customerName;
  private String businessNumber;
  private String customerPostCode;
  private String customerAddress;
  private String customerAddressDetail;
  private String customerTelNumber;
  
  public CustomerListResponseDto (CustomerListResultSet resultSet) {
    this.no = resultSet.getNo();
    this.companyCode = resultSet.getCompanyCode();
    this.customerCode = resultSet.getCustomerCode();
    this.customerName = resultSet.getCustomerName();
    this.businessNumber = resultSet.getBusinessNumber();
    this.customerPostCode = resultSet.getCustomerPostCode();
    this.customerAddress = resultSet.getCustomerAddres();
    this.customerAddressDetail = resultSet.getCustomerAddressDetail();
    this.customerTelNumber = resultSet.getCustomerTelNumber();
  }

  public static List<CustomerListResponseDto> copyList(List<CustomerListResultSet> resultSets) {
    List<CustomerListResponseDto> customerList = new ArrayList<>();

    for (CustomerListResultSet resultSet : resultSets) {
      CustomerListResponseDto customer = new CustomerListResponseDto(resultSet);
      customerList.add(customer);
    }

    return customerList;
  }
}
