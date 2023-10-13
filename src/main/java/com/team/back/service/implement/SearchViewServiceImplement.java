package com.team.back.service.implement;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.back.dto.request.searchView.GetFundsListRequestDto;
import com.team.back.dto.response.ResponseDto;
import com.team.back.dto.response.accounting.GetInOutComeListResponseDto;
import com.team.back.dto.response.accounting.InOutComeResponseDto;
import com.team.back.dto.response.searchView.FundsResponseDto;
import com.team.back.dto.response.searchView.GetFundsListResponseDto;
import com.team.back.entity.FundsViewEntity;
import com.team.back.repository.FundsViewRepository;
import com.team.back.service.SearchViewService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SearchViewServiceImplement implements SearchViewService {
     
     private final FundsViewRepository fundsViewRepository;

     @Override
     public ResponseEntity<? super GetFundsListResponseDto> getfundsList(GetFundsListRequestDto requestBody) {
          List<FundsResponseDto> fundsList = null;
          String start = requestBody.getFundDateStart();
          String end = requestBody.getFundDateEnd();

          try{ 
               List<FundsViewEntity> fundsViewEntities = fundsViewRepository.getFundsList(start, end);
               fundsList = FundsResponseDto.copyEntityList(fundsViewEntities);
               
          } catch(Exception exception){
               exception.printStackTrace();
               return ResponseDto.databaseError();
          }

          return GetFundsListResponseDto.success(fundsList);
     }
}
