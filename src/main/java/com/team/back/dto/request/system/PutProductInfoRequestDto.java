package com.team.back.dto.request.system;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.UniqueElements;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PutProductInfoRequestDto {

  @NotBlank
  private Integer companyCode;

  @NotBlank
  private Integer productCode;

  @NotBlank
  @UniqueElements
  private String productName;

  @NotBlank
  private Integer procurementCategory;

  @NotBlank
  private Double productPrice;
  
}
