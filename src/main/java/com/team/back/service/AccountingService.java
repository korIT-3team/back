package com.team.back.service;

import org.springframework.http.ResponseEntity;

import com.team.back.dto.request.accounting.GetInOutComeListRequestDto;
import com.team.back.dto.request.accounting.GetInvoiceDetailRequestDto;
import com.team.back.dto.request.accounting.GetInvoiceListRequestDto;
import com.team.back.dto.response.accounting.GetInOutComeListResponseDto;
import com.team.back.dto.response.accounting.GetInvoiceDetailIncentiveInfoResponseDto;
import com.team.back.dto.response.accounting.GetInvoiceDetailOrderInfoResponseDto;
import com.team.back.dto.response.accounting.GetInvoiceDetailSalesInfoResponseDto;
import com.team.back.dto.response.accounting.GetInvoiceListResponseDto;
import com.team.back.dto.response.accounting.GetInvoiceTypeListResponseDto;

public interface AccountingService {
     ResponseEntity<? super GetInvoiceListResponseDto> getInvoiceList(GetInvoiceListRequestDto dto);
     ResponseEntity<? super GetInvoiceDetailOrderInfoResponseDto> getInvoiceDetailOrderInfo(GetInvoiceDetailRequestDto requestBody);
     ResponseEntity<? super GetInvoiceDetailSalesInfoResponseDto> getInvoiceDetailSalesInfo(GetInvoiceDetailRequestDto requestBody);
     ResponseEntity<? super GetInvoiceDetailIncentiveInfoResponseDto> getInvoiceDetailIncentiveInfo(GetInvoiceDetailRequestDto requestBody);
     ResponseEntity<? super GetInOutComeListResponseDto> getInOutComeList(GetInOutComeListRequestDto requestBody);
     ResponseEntity<? super GetInvoiceTypeListResponseDto> getInvoiceType();
}
