package com.team.back.dto.response.sales;


import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.resultSets.ReleaseInfoListResultSet;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReleaseInfoListResponseDto {
  
  private int no;
  private int releaseCodeInfo;
  private String releaseDate;
  private int customerCodeInfo;
  private int productCode;
  private String productName;
  private int orderQuantity;
  private double productPrice;
  private double supplyPrice;
  private double surtax;
  private double totalPrice;

  public ReleaseInfoListResponseDto (ReleaseInfoListResultSet resultSet) {
    this.no = resultSet.getNo();
    this.releaseCodeInfo = resultSet.getReleaseCodeInfo();
    this.releaseDate = resultSet.getReleaseDate();
    this.customerCodeInfo = resultSet.getCustomerCodeInfo();
    this.productCode = resultSet.getProductCode();
    this.productName = resultSet.getProductName();
    this.orderQuantity = resultSet.getOrderQuantity();
    this.productPrice = resultSet.getProductPrice();
    this.supplyPrice = resultSet.getSupplyPrice();
    this.surtax = resultSet.getSurtax();
    this.totalPrice = resultSet.getTotalPrice();
  }

  public static List<ReleaseInfoListResponseDto> copyList(List<ReleaseInfoListResultSet> resultSets) {
    List<ReleaseInfoListResponseDto> releaseInfoList = new ArrayList<>();

    for (ReleaseInfoListResultSet resultSet: resultSets) {
      ReleaseInfoListResponseDto releaseInfo = new ReleaseInfoListResponseDto(resultSet);
      releaseInfoList.add(releaseInfo);
    }

    return releaseInfoList;
  }
}
