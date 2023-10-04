package com.team.back.dto.request.accounting;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GetInvoiceListRequestDto {
    private int departmentCode;
    private int employeeCode;
    @NotBlank
    private String invoiceDateStart;
    @NotBlank
    private String invoiceDateEnd;
    @NotNull
    private int invoiceType;
}
