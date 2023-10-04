package com.team.back.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.back.dto.request.accounting.GetInvoiceListRequestDto;
import com.team.back.dto.response.accounting.GetInvoiceListResponseDto;
import com.team.back.service.AccountingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/accounting")
@RequiredArgsConstructor
public class AccountingController {

     private final AccountingService accountingService;

     // API : 회사 정보 불러오기 메서드 //
     @GetMapping("/invoice")
     public ResponseEntity<? super GetInvoiceListResponseDto> getInvoiceList(
          @AuthenticationPrincipal Integer employeeCode,
          @RequestBody @Valid GetInvoiceListRequestDto requestBody
     ) {
          ResponseEntity<? super GetInvoiceListResponseDto> response = accountingService.getInvoiceList(employeeCode, requestBody);
          return response;
     }
}
