package com.team.back.dto.request.accounting;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GetInvoiceListRequestDto {
    private Integer departmentCode;
    private Integer employeeCode;
    @NotBlank
    private String invoiceDateStart;
    @NotBlank
    private String invoiceDateEnd;
    private String invoiceTypeName;
}
