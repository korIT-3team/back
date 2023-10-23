package com.team.back.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int companyCode;
  private int customerCode;
  private String customerName;
  private String customerBusinessNumber;
  private String customerPostCode;
  private String customerAddress;
  private String customerAddressDetail;
  private String customerTelNumber;

  public CustomerEntity(PutCustomerInfoRequestDto dto) {
    this.companyCode = dto.getCustomerCompanyCode();
    this.customerCode = dto.getCustomerCodeInfo();
    this.customerName = dto.getCustomerNameInfo();
    this.customerBusinessNumber = dto.getCustomerBusinessNumber();
    this.customerPostCode = dto.getCustomerPostCode();
    this.customerAddress = dto.getCustomerAddress();
    this.customerAddressDetail = dto.getCustomerAddressDetail();
    this.customerTelNumber = dto.getCustomerTelNumber();
  }

}
