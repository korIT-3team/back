package com.team.back.dto.request.accounting;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GetInvoiceDetailRequestDto {
     @NotNull
     private Integer primaryKey;
}
