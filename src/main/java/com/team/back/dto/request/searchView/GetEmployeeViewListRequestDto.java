package com.team.back.dto.request.searchView;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GetEmployeeViewListRequestDto {
     private Integer employeeCode;
     private Integer departmentCode;
     private String employmentType;
}