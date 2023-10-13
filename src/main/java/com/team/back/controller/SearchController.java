package com.team.back.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.back.dto.request.searchView.GetFundsListRequestDto;
import com.team.back.dto.response.searchView.GetFundsListResponseDto;
import com.team.back.service.SearchViewService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/searchView")
@RequiredArgsConstructor
public class SearchController {

     private final SearchViewService searchViewService;

     // API : 사내자금현황 메서드 //
     @PostMapping("/check-funds")
     public ResponseEntity<? super GetFundsListResponseDto> getfundsList(
          @RequestBody @Valid GetFundsListRequestDto requestBody
     ) {
          ResponseEntity<? super GetFundsListResponseDto> response = searchViewService.getfundsList(requestBody);
          return response;
     }
}
