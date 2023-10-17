package com.team.back.dto.response.searchView;
import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.IncentiveViewEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class IncentiveViewResponseDto {
     private int incentiveCode;
     private String employeeName;
     private String incentiveCategoryName;
     private String paymentDate;
     private double incentivePrice;
     private String content;

     public IncentiveViewResponseDto(IncentiveViewEntity incentiveViewEntity){
          this.incentiveCode = incentiveViewEntity.getIncentiveCode();
          this.employeeName = incentiveViewEntity.getEmployeeName();
          this.incentiveCategoryName = incentiveViewEntity.getIncentiveCategoryName();
          this.paymentDate = incentiveViewEntity.getPaymentDate();
          this.incentivePrice = incentiveViewEntity.getIncentivePrice();
          this.content = incentiveViewEntity.getContent();
     }
     
     public static List<IncentiveViewResponseDto> copyEntityList(List<IncentiveViewEntity> incentiveViewEntities) {
          List<IncentiveViewResponseDto> incentiveList = new ArrayList<>();

          for (IncentiveViewEntity incentiveViewEntity : incentiveViewEntities) {
               IncentiveViewResponseDto dto = new IncentiveViewResponseDto(incentiveViewEntity);
               incentiveList.add(dto);
          }

          return incentiveList;
     }
}
