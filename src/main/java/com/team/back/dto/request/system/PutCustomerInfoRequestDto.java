package com.team.back.dto.request.system;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PutCustomerInfoRequestDto {

  @NotNull
  private Integer companyCode = 1;

  private String customerName;

  @NotBlank
  private String customerBusinessNumber;

  @NotBlank
  private String customerPostCode;

  @NotBlank
  private String customerAddress;

  @NotBlank
  private String customerAddressDetail;

  @NotBlank
  private String customerTelNumber;
  
}
