package com.team.back.dto.response.accounting;

import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.UserDefineDetailEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InvoiceTypeResponseDto {
     private int userDefineDetailCode;
     private String userDefineDetailName;

     public InvoiceTypeResponseDto(UserDefineDetailEntity invoiceTypeEntity){
          this.userDefineDetailCode = invoiceTypeEntity.getUserDefineDetailCode();
          this.userDefineDetailName = invoiceTypeEntity.getUserDefineDetailName();
     }
     
     public static List<InvoiceTypeResponseDto> copyEntityList(List<UserDefineDetailEntity> invoiceTypeEntities) {
          List<InvoiceTypeResponseDto> invoiceTypeList = new ArrayList<>();

          for (UserDefineDetailEntity invoiceTypeEntity : invoiceTypeEntities) {
               InvoiceTypeResponseDto dto = new InvoiceTypeResponseDto(invoiceTypeEntity);
               invoiceTypeList.add(dto);
          }

          return invoiceTypeList;
     }
}
