package com.team.back.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.back.dto.request.accounting.GetInvoiceDetailRequestDto;
import com.team.back.dto.request.accounting.GetInvoiceListRequestDto;
import com.team.back.dto.response.accounting.GetInvoiceDetailOrderInfoResponseDto;
import com.team.back.dto.response.accounting.GetInvoiceDetailSalesInfoResponseDto;
import com.team.back.dto.response.accounting.GetInvoiceListResponseDto;
import com.team.back.dto.response.accounting.InvoiceResponseDto;
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
     	
     // API : 전표 상세 조회 메서드 //
     @GetMapping("/invoice/{invoiceCode}")
     public ResponseEntity<? super InvoiceResponseDto> getInvoiceDetail(
          @PathVariable(value="invoiceCode", required=true) Integer invoiceCode
     ) {
          ResponseEntity<? super InvoiceResponseDto> response = accountingService.getInvoiceDetail(invoiceCode);
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
}
