package com.team.back.dto.request.system;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PutProductInfoRequestDto {

  @NotNull
  private Integer productCodeInfo;

  @NotBlank
  private String productName;

  @NotBlank
  private Integer procurementCategory;

  @NotBlank
  private Double productPrice;
  
}
