package com.team.back.dto.response.searchView;

import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.EmployeeViewEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EmployeeViewResponseDto {
     private int no;
     private int employeeCode;
     private String employeeName;
     private String genderName;
     private String departmentName;
     private String position;
     private String email;
     private String employmentType;

     public EmployeeViewResponseDto(EmployeeViewEntity employeeViewEntity){
          this.no = employeeViewEntity.getNo();
          this.employeeCode = employeeViewEntity.getEmployeeCode();
          this.employeeName = employeeViewEntity.getEmployeeName();
          this.genderName = employeeViewEntity.getGenderName();
          this.departmentName = employeeViewEntity.getDepartmentName();
          this.position = employeeViewEntity.getPosition();
          this.email = employeeViewEntity.getEmail();
          this.employmentType = employeeViewEntity.getEmploymentType();
     }
     
     public static List<EmployeeViewResponseDto> copyEntityList(List<EmployeeViewEntity> employeeViewEntities) {
          List<EmployeeViewResponseDto> employeeViewList = new ArrayList<>();

          for (EmployeeViewEntity employeeViewEntity : employeeViewEntities) {
               EmployeeViewResponseDto dto = new EmployeeViewResponseDto(employeeViewEntity);
               employeeViewList.add(dto);
          }

          return employeeViewList;
     }
}
