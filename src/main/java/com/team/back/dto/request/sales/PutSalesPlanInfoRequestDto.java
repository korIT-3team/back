package com.team.back.dto.request.sales;

import javax.validation.constraints.NotBlank;
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

    @NotBlank
    private String salesPlanProjectName;

    @NotNull
    private Integer salesPlanDepartmentCodeInfo;
    
    @NotNull
    private Integer salesPlanEmployeeCodeInfo;
    
    @NotNull
    private Integer salesPlanCompanyCodeInfo;
    
    @NotBlank
    private String salesPlanDate;

    @NotNull
    private Integer salesPlanProductCodeInfo;

    @NotNull
    private String salesPlanProductNameInfo;

    @NotBlank
    private Integer salesPlanQuantity;

    @NotNull
    private Integer salesPlanExchangeRateCode;

    private Double salesPlanExchangeRate;

    @NotBlank
    private Double salesPlanExpectPrice;

    private Double salesPlanExpectTotalPrice;
    
    private Double salesPlanExpectKoreanPrice;


}
