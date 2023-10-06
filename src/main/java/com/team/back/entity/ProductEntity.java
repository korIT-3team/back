package com.team.back.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.team.back.dto.request.system.PutProductInfoRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="product")
@Table(name="product")
public class ProductEntity {

  @Id
  private int companyCode;
  private int productCode;
  private String productName;
  private int procurementCategory;
  private double productPrice;

  public ProductEntity(PutProductInfoRequestDto dto) {
    this.companyCode = 1;
    this.productCode = 2000;
    this.productName = dto.getProductName();
    this.procurementCategory = dto.getProcurementCategory();
    this.productPrice = dto.getProductPrice();
  }
  
}
