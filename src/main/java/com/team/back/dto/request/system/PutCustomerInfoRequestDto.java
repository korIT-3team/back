package com.team.back.dto.request.system;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PutCustomerInfoRequestDto {

  @NotNull
  private Integer customerCodeInfo;

  @NotNull
  private Integer customerCompanyCode = 1;

  @NotNull
  private String customerNameInfo;

  @NotBlank
  private String customerBusinessNumber;

  @NotBlank
  private String customerPostCode;

  @NotBlank
  private String customerAddress;

  @NotBlank
  private String customerAddressDetail;

  @NotBlank @Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}$")
  private String customerTelNumber;
  
}
