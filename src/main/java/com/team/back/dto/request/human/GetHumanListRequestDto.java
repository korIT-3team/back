package com.team.back.dto.request.human;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GetHumanListRequestDto {
  private Integer humanDepartmentCode;
  private Integer humanEmployeeCode;
  private Integer humanEmploymentType;
}
