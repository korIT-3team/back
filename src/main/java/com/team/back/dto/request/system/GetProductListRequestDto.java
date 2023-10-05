package com.team.back.dto.request.system;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GetProductListRequestDto {

  private int companyCode;
  
  private int productCode;
  
  @NotBlank
  private String productName;

  @NotNull
  private int procurementCategory;
  
  @NotBlank
  private double productPrice;

  
}