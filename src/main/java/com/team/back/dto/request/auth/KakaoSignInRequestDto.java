package com.team.back.dto.request.auth;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class KakaoSignInRequestDto {
     @NotNull
     private Integer employeeCode;
}
