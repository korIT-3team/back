package com.team.back.dto.response.searchView;

import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.UserDefineDetailEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class IncentiveTypeResponseDto {
     private int userDefineDetailCode;
     private String userDefineDetailName;

     public IncentiveTypeResponseDto(UserDefineDetailEntity userDefineDetailEntity){
          this.userDefineDetailCode = userDefineDetailEntity.getUserDefineDetailCode();
          this.userDefineDetailName = userDefineDetailEntity.getUserDefineDetailName();
     }
     
     public static List<IncentiveTypeResponseDto> copyEntityList(List<UserDefineDetailEntity> userDefineDetailEntities) {
          List<IncentiveTypeResponseDto> incentiveTypeList = new ArrayList<>();

          for (UserDefineDetailEntity userDefineDetailEntity : userDefineDetailEntities) {
               IncentiveTypeResponseDto dto = new IncentiveTypeResponseDto(userDefineDetailEntity);
               incentiveTypeList.add(dto);
          }

          return incentiveTypeList;
     }
}
