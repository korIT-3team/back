package com.team.back.dto.response.Human;

import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.EmployeeViewEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class HumanListResponseDto {
  private int no;
  private int employeeCode;
  private String employeeName;
  private String departmentName;

  public HumanListResponseDto (EmployeeViewEntity resultSet) {
    this.no = resultSet.getNo();
    this.employeeCode = resultSet.getEmployeeCode();
    this.employeeName = resultSet.getEmployeeName();
    this.departmentName = resultSet.getDepartmentName();
  }

  public static List<HumanListResponseDto> copyList(List<EmployeeViewEntity> resultSets) {
    List<HumanListResponseDto> humanList = new ArrayList<>();

    for (EmployeeViewEntity resultSet : resultSets) {
      HumanListResponseDto human = new HumanListResponseDto(resultSet);
      humanList.add(human);
    }

    return humanList;
  }
  
}
