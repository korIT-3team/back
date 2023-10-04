package com.team.back.dto.response.system;

import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.resultSets.DepartmentListResultSet;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DepartmentListResponseDto {
  private int no;
  private int departmentCode;
  private int companyCode;
  private String departmentName;
  private String departmentStartDate;
  private String departmentEndDate;
  private String departmetTelnumber;
  private String departmentFax;

  public DepartmentListResponseDto (DepartmentListResultSet resultSet) {
    this.no = resultSet.getNo();
    this.companyCode = resultSet.getCompanyCode();
    this.departmentCode = resultSet.getDepartmentCode();
    this.departmentName = resultSet.getDepartmentName();
    this.departmentStartDate = resultSet.getDepartmentStartDate();
    this.departmentEndDate = resultSet.getDepartmentEndDate();
    this.departmetTelnumber = resultSet.getDepartmentTelnumber();
    this.departmentFax = resultSet.getDepartmentFax();
  }

  public static List<DepartmentListResponseDto> copyList(List<DepartmentListResultSet> resultSets) {
    List<DepartmentListResponseDto> departmentList = new ArrayList<>();

    for (DepartmentListResultSet resultSet : resultSets) {
      DepartmentListResponseDto department = new DepartmentListResponseDto(resultSet);
      departmentList.add(department);
    }

    return departmentList;
  }

}
