package com.team.back.dto.response.system;

import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.resultSets.ProductListResultSet;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductListResponseDto {
  private int no;
  private int productCode;
  private String productName;
  private int procurementCategory;
  private Double productPrice;

  public ProductListResponseDto (ProductListResultSet resultSet) {
    this.no = resultSet.getNo();
    this.productCode = resultSet.getProductCode();
    this.productName = resultSet.getProductName();
    this.procurementCategory = resultSet.getProcurementCategory();
    this.productPrice = resultSet.getProductPrice();
  }

  public static List<ProductListResponseDto> copyList(List<ProductListResultSet> resultSets) {
    List<ProductListResponseDto> productList = new ArrayList<>();

    for (ProductListResultSet resultSet: resultSets) {
      ProductListResponseDto product = new ProductListResponseDto(resultSet);
      productList.add(product);
    }

    return productList;
  }


}
