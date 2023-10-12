package com.team.back.dto.response.accounting;

import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.InOutComeViewEntity;

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
     private double fundBalance;
     
     public InOutComeResponseDto(InOutComeViewEntity inOutComeViewEntity){
          this.fundingCode = inOutComeViewEntity.getFundingCode();
          this.fundDate = inOutComeViewEntity.getFundDate();
          this.salesPlanCode = inOutComeViewEntity.getSalesPlanCode();
          this.customerName = inOutComeViewEntity.getCustomerName();
          this.price = inOutComeViewEntity.getPrice();
          this.priceDetail = inOutComeViewEntity.getPriceDetail();
          this.taxType = inOutComeViewEntity.getTaxType();
          this.fundBalance = inOutComeViewEntity.getFundBalance();
     }
     
     public static List<InOutComeResponseDto> copyEntityList(List<InOutComeViewEntity> inOutComeViewEntities) {
          List<InOutComeResponseDto> inOutComeList = new ArrayList<>();

          for (InOutComeViewEntity inOutComeViewEntity : inOutComeViewEntities) {
               InOutComeResponseDto dto = new InOutComeResponseDto(inOutComeViewEntity);
               inOutComeList.add(dto);
          }

          return inOutComeList;
     }
}
