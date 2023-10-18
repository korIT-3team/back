package com.team.back.dto.response.searchView;

import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.UserDefineDetailEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EmploymentTypeResponseDto {
     private int userDefineDetailCode;
     private String userDefineDetailName;

     public EmploymentTypeResponseDto(UserDefineDetailEntity userDefineDetailEntity){
          this.userDefineDetailCode = userDefineDetailEntity.getUserDefineDetailCode();
          this.userDefineDetailName = userDefineDetailEntity.getUserDefineDetailName();
     }
     
     public static List<EmploymentTypeResponseDto> copyEntityList(List<UserDefineDetailEntity> userDefineDetailEntities) {
          List<EmploymentTypeResponseDto> invoiceTypeList = new ArrayList<>();

          for (UserDefineDetailEntity userDefineDetailEntity : userDefineDetailEntities) {
               EmploymentTypeResponseDto dto = new EmploymentTypeResponseDto(userDefineDetailEntity);
               invoiceTypeList.add(dto);
          }

          return invoiceTypeList;
     }
}
