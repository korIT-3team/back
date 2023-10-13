package com.team.back.service;

import org.springframework.http.ResponseEntity;

import com.team.back.dto.request.searchView.GetFundsListRequestDto;
import com.team.back.dto.response.searchView.GetFundsListResponseDto;

public interface SearchViewService {
     ResponseEntity<? super GetFundsListResponseDto> getfundsList(GetFundsListRequestDto requestBody);
}
