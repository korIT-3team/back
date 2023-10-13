package com.team.back.dto.request.sales;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GetSalesPlanListRequestDto {
  
  @NotBlank
  private Integer departmentCode;
  @NotBlank
  private Integer employeeCode;
  @NotBlank
  private String planDate;
  @NotNull
  private Integer productCode;
  @NotNull
  private String productName;
  @NotBlank
  private Integer planQuantity;
  @NotBlank
  private Integer exchangeType;
  private Double exchangeRate;
  @NotBlank
  private Double expectPrice;
  private Double expectTotalPrice;

}
