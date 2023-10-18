package com.team.back.dto.response.accounting;

import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.FundsViewEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InOutComeResponseDto {
     private int fundingCode;
     private String fundDate;
     private int salesPlanCode;
     private String customerName;
     private double price;
     private String priceDetail;
     private int taxType;
     private String taxTypeName;
     private double fundBalance;
     
     public InOutComeResponseDto(FundsViewEntity fundsViewEntity){
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
     
     public static List<InOutComeResponseDto> copyEntityList(List<FundsViewEntity> fundsViewEntities) {
          List<InOutComeResponseDto> inOutComeList = new ArrayList<>();

          for (FundsViewEntity fundsViewEntity : fundsViewEntities) {
               InOutComeResponseDto dto = new InOutComeResponseDto(fundsViewEntity);
               inOutComeList.add(dto);
          }

          return inOutComeList;
     }
}
