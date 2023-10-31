package com.team.back.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int productCode;
  private String productName;
  private int procurementCategory;
  private double productPrice;

  public ProductEntity(PutProductInfoRequestDto dto) {
    this.productCode = dto.getProductCodeInfo();
    this.productName = dto.getProductName();
    this.procurementCategory = dto.getProcurementCategory();
    this.productPrice = dto.getProductPrice();
  }
  
}
