package com.team.back.dto.request.system;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.UniqueElements;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PutCustomerInfoRequestDto {
  
  private Integer no;

  @NotBlank
  private Integer companyCode;

  @NotBlank
  private Integer customerCode;

  @NotBlank
  @UniqueElements
  private String customerName;

  @NotBlank
  @UniqueElements
  private String businessNumber;

  @NotBlank
  private String customerAddress;

  @NotBlank
  private String customerAddressDetail;

  @NotBlank
  @UniqueElements
  private String customerTelNumber;
  
}
