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
  private Integer customerCode;

  @NotBlank
  private String customerName;

}
