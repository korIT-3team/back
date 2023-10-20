package com.team.back.service;

import org.springframework.http.ResponseEntity;

import com.team.back.dto.request.searchView.GetEmployeeViewListRequestDto;
import com.team.back.dto.request.searchView.GetFundsListRequestDto;
import com.team.back.dto.request.searchView.GetIncentiveViewListRequestDto;
import com.team.back.dto.response.searchView.GetEmployeeViewListResponseDto;
import com.team.back.dto.response.searchView.GetEmploymentTypeListResponseDto;
import com.team.back.dto.response.searchView.GetFundsListResponseDto;
import com.team.back.dto.response.searchView.GetIncentiveTypeListResponseDto;
import com.team.back.dto.response.searchView.GetIncentiveViewListResponseDto;

public interface SearchViewService {
     ResponseEntity<? super GetFundsListResponseDto> getfundsList(GetFundsListRequestDto requestBody);
     ResponseEntity<? super GetEmployeeViewListResponseDto> getEmployeeViewList(GetEmployeeViewListRequestDto requestBody);
     ResponseEntity<? super GetIncentiveViewListResponseDto> getIncentiveViewList(GetIncentiveViewListRequestDto requestBody);
     ResponseEntity<? super GetEmploymentTypeListResponseDto> getEmploymentType();
     ResponseEntity<? super GetIncentiveTypeListResponseDto> getIncentiveType();
}
