package com.team.back.dto.request.accounting;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GetInOutComeListRequestDto {
    @NotBlank
    private String fundDateStart;
    @NotBlank
    private String fundDateEnd;
    private Integer customerCode;
    private Integer salesPlanCode;
}
