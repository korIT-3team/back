package com.team.back.service.implement;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.back.dto.request.common.GetEmployeeDetailCodeRequestDto;
import com.team.back.dto.response.ResponseDto;
import com.team.back.dto.response.common.GetSearchCodeListResponseDto;
import com.team.back.dto.response.common.SearchCodeResponseDto;
import com.team.back.entity.resultSets.SearchCodeResultSet;
import com.team.back.repository.SearchCodeRepository;
import com.team.back.service.SearchCodeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SearchCodeServiceImplement implements SearchCodeService{
     
     private final SearchCodeRepository searchCodeRepository;

     @Override
     public ResponseEntity<? super GetSearchCodeListResponseDto> getEmployeeList(GetEmployeeDetailCodeRequestDto requestBody) {
          List<SearchCodeResponseDto> searchCodeList = null;
          Integer emCode = requestBody.getEmployeeCode();

          try{
               String strEmCode = emCode == null ? "" : Integer.toString(emCode);

               List<SearchCodeResultSet> resultSets = searchCodeRepository.getEmployeeList(strEmCode);
         
               searchCodeList = SearchCodeResponseDto.copyList(resultSets);
         
          } catch(Exception exception) {
               exception.printStackTrace();
               return ResponseDto.databaseError();
          }

          return GetSearchCodeListResponseDto.success(searchCodeList);
     }
     
}
