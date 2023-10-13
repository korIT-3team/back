package com.team.back.dto.request.sales;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PutSalesPlanInfoRequestDto {
  
  @NotNull
  private Integer salesPlanCodeInfo;

  @NotNull
  private String projectNameInfo;

  @NotNull
  private Integer employeeCodeInfo;

  @NotNull
  private Integer departmentCodeInfo = 1;

  @NotNull
  private Integer salesPlanCompanyCode = 1;

  @NotNull
  private String planDate;

  @NotNull
  private Integer productCode;

  @NotNull
  private String productName;

  @NotNull
  private Integer planQuantity;

  private Integer exchangeRateCode;

  private Double exchangeRate;

  @NotNull
  private Double expectPrice;

  @NotNull
  private Double expectTotalPrice;

  @NotNull
  private Double expectKoreanPrice;


}
