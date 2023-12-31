package com.team.back.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.back.dto.request.searchView.GetEmployeeViewListRequestDto;
import com.team.back.dto.request.searchView.GetFundsListRequestDto;
import com.team.back.dto.request.searchView.GetIncentiveViewListRequestDto;
import com.team.back.dto.response.searchView.GetFundsListResponseDto;
import com.team.back.dto.response.searchView.GetIncentiveTypeListResponseDto;
import com.team.back.dto.response.accounting.GetInvoiceTypeListResponseDto;
import com.team.back.dto.response.searchView.GetEmployeeViewListResponseDto;
import com.team.back.dto.response.searchView.GetEmploymentTypeListResponseDto;
import com.team.back.dto.response.searchView.GetIncentiveViewListResponseDto;
import com.team.back.service.SearchViewService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/searchView")
@RequiredArgsConstructor
public class SearchController {

     private final SearchViewService searchViewService;

     // API : 조회조건 : 재직구분 콤보박스 조회 메서드 //
     @GetMapping("/employee-list")
     public ResponseEntity<? super GetEmploymentTypeListResponseDto> getEmploymentType(
     ) {
          ResponseEntity<? super GetEmploymentTypeListResponseDto> response = searchViewService.getEmploymentType();
          return response;
     }

     // API : 조회조건 : 급상여구분 콤보박스 조회 메서드 //
     @GetMapping("/incentive-list")
     public ResponseEntity<? super GetIncentiveTypeListResponseDto> getIncentiveType(
     ) {
          ResponseEntity<? super GetIncentiveTypeListResponseDto> response = searchViewService.getIncentiveType();
          return response;
     }

     // API : 사내자금현황 메서드 //
     @PostMapping("/check-funds")
     public ResponseEntity<? super GetFundsListResponseDto> getfundsList(
          @RequestBody @Valid GetFundsListRequestDto requestBody
     ) {
          ResponseEntity<? super GetFundsListResponseDto> response = searchViewService.getfundsList(requestBody);
          return response;
     }

     // API : 사원목록조회 메서드 //
     @PostMapping("/employee-list")
     public ResponseEntity<? super GetEmployeeViewListResponseDto> getEmployeeViewList(
          @RequestBody @Valid GetEmployeeViewListRequestDto requestBody
     ) {
          ResponseEntity<? super GetEmployeeViewListResponseDto> response = searchViewService.getEmployeeViewList(requestBody);
          return response;
     }

     // API : 급여정보조회 메서드 //
     @PostMapping("/incentive-list")
     public ResponseEntity<? super GetIncentiveViewListResponseDto> getIncentiveViewList(
          @RequestBody @Valid GetIncentiveViewListRequestDto requestBody
     ) {
          ResponseEntity<? super GetIncentiveViewListResponseDto> response = searchViewService.getIncentiveViewList(requestBody);
          return response;
     }
}
