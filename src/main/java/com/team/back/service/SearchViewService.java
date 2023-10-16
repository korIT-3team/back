package com.team.back.service;

import org.springframework.http.ResponseEntity;

import com.team.back.dto.request.searchView.GetEmployeeViewListRequestDto;
import com.team.back.dto.request.searchView.GetFundsListRequestDto;
import com.team.back.dto.response.searchView.GetEmployeeViewListResponseDto;
import com.team.back.dto.response.searchView.GetFundsListResponseDto;

public interface SearchViewService {
     ResponseEntity<? super GetFundsListResponseDto> getfundsList(GetFundsListRequestDto requestBody);
     ResponseEntity<? super GetEmployeeViewListResponseDto> getEmployeeViewList(GetEmployeeViewListRequestDto requestBody);
}
