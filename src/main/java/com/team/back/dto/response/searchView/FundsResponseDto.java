package com.team.back.dto.response.searchView;

import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.FundsViewEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FundsResponseDto {
     private int fundingCode;
     private String fundDate;
     private int salesPlanCode;
     private String customerName;
     private double price;
     private String priceDetail;
     private int taxType;
     private String taxTypeName;
     private double fundBalance;
     
     public FundsResponseDto(FundsViewEntity fundsViewEntity){
          this.fundingCode = fundsViewEntity.getFundingCode();
          this.fundDate = fundsViewEntity.getFundDate();
          this.salesPlanCode = fundsViewEntity.getSalesPlanCode();
          this.customerName = fundsViewEntity.getCustomerName();
          this.price = fundsViewEntity.getPrice();
          this.priceDetail = fundsViewEntity.getPriceDetail();
          this.taxType = fundsViewEntity.getTaxType();
          this.taxTypeName = fundsViewEntity.getTaxTypeName();
          this.fundBalance = fundsViewEntity.getFundBalance();
     }
     
     public static List<FundsResponseDto> copyEntityList(List<FundsViewEntity> fundsViewEntities) {
          List<FundsResponseDto> fundsList = new ArrayList<>();

          for (FundsViewEntity fundsViewEntity : fundsViewEntities) {
               FundsResponseDto dto = new FundsResponseDto(fundsViewEntity);
               fundsList.add(dto);
          }

          return fundsList;
     }
}
