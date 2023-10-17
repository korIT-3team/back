package com.team.back.dto.response.system.Employee;

import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.resultSets.UserDefineListResultSet;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SystemEmpUserDefineListResponseDto {
  private Integer no;
  private Integer systemUserDefineCode;
  private String systemUserDefineName;
  private Integer systemUserDefineDetailCode;
  private String systemUserDefineDetailName;

  public SystemEmpUserDefineListResponseDto (UserDefineListResultSet resultSet) {
    this.no = resultSet.getNo();
      this.systemUserDefineCode = resultSet.getUserDefineCode();
      this.systemUserDefineName = resultSet.getUserDefineName();
      this.systemUserDefineDetailCode = resultSet.getUserDefineDetailCode();
      this.systemUserDefineDetailName = resultSet.getUserDefineDetailName();
    }  

  public static List<SystemEmpUserDefineListResponseDto> copyList(List<UserDefineListResultSet> resultSets) {
    List<SystemEmpUserDefineListResponseDto> systemEmpUserDefineList = new ArrayList<>();

    for (UserDefineListResultSet resultSet : resultSets) {
      SystemEmpUserDefineListResponseDto systemEmpUserDefine = new SystemEmpUserDefineListResponseDto(resultSet);
      systemEmpUserDefineList.add(systemEmpUserDefine);
    }

    return systemEmpUserDefineList;
  }
  
}
