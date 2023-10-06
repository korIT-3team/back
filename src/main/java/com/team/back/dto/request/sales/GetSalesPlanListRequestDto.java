package com.team.back.dto.request.sales;

import javax.validation.constraints.NotBlank;

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
  private String planYear;
  @NotBlank
  private String planMonth;
  @NotBlank
  private String planQuantity;
  @NotBlank
  private Integer exchangeType;
  private Double exchangeRate;
  @NotBlank
  private Double expectPrice;
  private Double expectTotalPrice;

}
