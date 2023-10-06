package com.team.back.dto.request.system;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GetCustomerListRequestDto {

  @NotBlank
  private String customerName;

  @NotBlank
  private String businessNumber;

  @NotBlank
  private String postCode;

  @NotBlank
  private String customerAddress;

  private String customerAddressDetail;

  @NotBlank
  private String customerTelNumber;

}
