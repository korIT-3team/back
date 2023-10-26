package com.team.back.dto.response.human;

import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.UserDefineDetailEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EmploymentTypeResponseDto {
  private int userDefineDetailCode;
  private String  userDefineDetailName;

  public EmploymentTypeResponseDto(UserDefineDetailEntity employmentTypeEntity){
          this.userDefineDetailCode = employmentTypeEntity.getUserDefineDetailCode();
          this.userDefineDetailName = employmentTypeEntity.getUserDefineDetailName();
     }

     public static List<EmploymentTypeResponseDto> copyEntityList(List<UserDefineDetailEntity> employmentTypeEntities) {
          List<EmploymentTypeResponseDto> employmentTypeList = new ArrayList<>();

          for (UserDefineDetailEntity employmentTypeEntity : employmentTypeEntities) {
               EmploymentTypeResponseDto dto = new EmploymentTypeResponseDto(employmentTypeEntity);
               employmentTypeList.add(dto);
          }

          return employmentTypeList;
     }     
  
}
