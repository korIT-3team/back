package com.team.back.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.team.back.dto.request.system.PutCustomerInfoRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="customer")
@Table(name="customer")
public class CustomerEntity {
  
  @Id
  private int companyCode;
  private int customerCode;
  private String customerName;
  private String businessNumber;
  private String postCode;
  private String customerAddress;
  private String customerAddressDetail;
  private String customerTelNumber;

  public CustomerEntity(PutCustomerInfoRequestDto dto) {
    this.companyCode = 1;
    this.customerCode = 4000;
    this.customerName = dto.getCustomerName();
    this.businessNumber = dto.getBusinessNumber();
    this.postCode = dto.getPostCode();
    this.customerAddress = dto.getCustomerAddress();
    this.customerAddressDetail = dto.getCustomerAddressDetail();
    this.customerTelNumber = dto.getCustomerTelNumber();
  }

}
