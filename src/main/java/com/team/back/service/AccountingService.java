package com.team.back.service;

import org.springframework.http.ResponseEntity;

import com.team.back.dto.request.accounting.GetInvoiceListRequestDto;
import com.team.back.dto.response.accounting.GetInvoiceListResponseDto;

public interface AccountingService {
     ResponseEntity<? super GetInvoiceListResponseDto> getInvoiceList(Integer employeeCode, GetInvoiceListRequestDto dto);
}
