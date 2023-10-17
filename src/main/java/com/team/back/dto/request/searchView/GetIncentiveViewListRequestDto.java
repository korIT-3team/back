package com.team.back.dto.request.searchView;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GetIncentiveViewListRequestDto {
     @NotNull
     private Integer employeeCode;
     private Integer incentiveCategory;
     @NotBlank
     private String paymentDateStart;
     @NotBlank
     private String paymentDateEnd;
}
