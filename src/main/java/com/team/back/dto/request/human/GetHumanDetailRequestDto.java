package com.team.back.dto.request.human;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GetHumanDetailRequestDto {
     @NotNull
     private Integer employeeCode;  
}
