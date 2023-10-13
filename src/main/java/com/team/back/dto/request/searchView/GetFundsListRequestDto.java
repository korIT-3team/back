package com.team.back.dto.request.searchView;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GetFundsListRequestDto {
     @NotBlank
     private String fundDateStart;
     @NotBlank
     private String fundDateEnd;
}
