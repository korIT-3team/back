package com.team.back.service;

import org.springframework.http.ResponseEntity;

import com.team.back.dto.request.accounting.GetInvoiceDetailRequestDto;
import com.team.back.dto.request.accounting.GetInvoiceListRequestDto;
import com.team.back.dto.response.accounting.GetInvoiceDetailOrderInfoResponseDto;
import com.team.back.dto.response.accounting.GetInvoiceDetailSalesInfoResponseDto;
import com.team.back.dto.response.accounting.GetInvoiceListResponseDto;
import com.team.back.dto.response.accounting.InvoiceResponseDto;

public interface AccountingService {
     ResponseEntity<? super GetInvoiceListResponseDto> getInvoiceList(GetInvoiceListRequestDto dto);
     ResponseEntity<? super InvoiceResponseDto> getInvoiceDetail(Integer invoiceCode);
     ResponseEntity<? super GetInvoiceDetailOrderInfoResponseDto> getInvoiceDetailOrderInfo(GetInvoiceDetailRequestDto requestBody);
     ResponseEntity<? super GetInvoiceDetailSalesInfoResponseDto> getInvoiceDetailSalesInfo(GetInvoiceDetailRequestDto requestBody);
}
