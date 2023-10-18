package com.team.back.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.back.dto.request.accounting.GetInOutComeListRequestDto;
import com.team.back.dto.request.accounting.GetInvoiceDetailRequestDto;
import com.team.back.dto.request.accounting.GetInvoiceListRequestDto;
import com.team.back.dto.response.accounting.GetInvoiceDetailOrderInfoResponseDto;
import com.team.back.dto.response.accounting.GetInvoiceDetailSalesInfoResponseDto;
import com.team.back.dto.response.accounting.GetInvoiceDetailIncentiveInfoResponseDto;
import com.team.back.dto.response.accounting.GetInOutComeListResponseDto;
import com.team.back.dto.response.accounting.GetInvoiceListResponseDto;
import com.team.back.dto.response.accounting.GetInvoiceTypeListResponseDto;
import com.team.back.service.AccountingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/accounting")
@RequiredArgsConstructor
public class AccountingController {

     private final AccountingService accountingService;

     // API : 전표 목록 조회 메서드 //
     @PostMapping("/invoice")
     public ResponseEntity<? super GetInvoiceListResponseDto> getInvoiceList(
          @RequestBody @Valid GetInvoiceListRequestDto requestBody
     ) {
          ResponseEntity<? super GetInvoiceListResponseDto> response = accountingService.getInvoiceList(requestBody);
          return response;
     }

     // API : 조회조건 : 전표유형 콤보박스 조회 메서드 //
     @GetMapping("/invoice")
     public ResponseEntity<? super GetInvoiceTypeListResponseDto> getInvoiceType(
     ) {
          ResponseEntity<? super GetInvoiceTypeListResponseDto> response = accountingService.getInvoiceType();
          return response;
     }
     
     // API : 수주 전표 조회 메서드 //
     @PostMapping("/invoice/{invoiceCode}/order-info")
     public ResponseEntity<? super GetInvoiceDetailOrderInfoResponseDto> getInvoiceDetailOrderInfo(
          @RequestBody @Valid GetInvoiceDetailRequestDto requestBody
     ) {
          ResponseEntity<? super GetInvoiceDetailOrderInfoResponseDto> response = accountingService.getInvoiceDetailOrderInfo(requestBody);
          return response;
     }

     // API : 매출 전표 조회 메서드 //
     @PostMapping("/invoice/{invoiceCode}/sales-info")
     public ResponseEntity<? super GetInvoiceDetailSalesInfoResponseDto> getInvoiceDetailSalesInfo(
          @RequestBody @Valid GetInvoiceDetailRequestDto requestBody
     ) {
          ResponseEntity<? super GetInvoiceDetailSalesInfoResponseDto> response = accountingService.getInvoiceDetailSalesInfo(requestBody);
          return response;
     }

     // API : 급/상여 전표 조회 메서드 //
     @PostMapping("/invoice/{invoiceCode}/incentive")
     public ResponseEntity<? super GetInvoiceDetailIncentiveInfoResponseDto> getInvoiceDetailIncentiveInfo(
          @RequestBody @Valid GetInvoiceDetailRequestDto requestBody
     ) {
          ResponseEntity<? super GetInvoiceDetailIncentiveInfoResponseDto> response = accountingService.getInvoiceDetailIncentiveInfo(requestBody);
          return response;
     }

     // API : 매입매출장 메서드 //
     @PostMapping("/inout-come")
     public ResponseEntity<? super GetInOutComeListResponseDto> getInOutComeList(
          @RequestBody @Valid GetInOutComeListRequestDto requestBody
     ) {
          ResponseEntity<? super GetInOutComeListResponseDto> response = accountingService.getInOutComeList(requestBody);
          return response;
     }
}
