package com.team.back.dto.request.system;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PutCustomerInfoRequestDto {

  private Integer customerCodeInfo;

  @NotBlank
  private String customerNameInfo;

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
