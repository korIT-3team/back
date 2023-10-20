package com.team.back.service.implement;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.back.dto.request.common.GetCustomerDetailCodeRequestDto;
import com.team.back.dto.request.common.GetDepartmentDetailCodeRequestDto;
import com.team.back.dto.request.common.GetEmployeeDetailCodeRequestDto;
import com.team.back.dto.request.common.GetProjectDetailCodeRequestDto;
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
          Integer code = requestBody.getEmployeeCode();

          try{
               String strCode = code == null ? "" : Integer.toString(code);

               List<SearchCodeResultSet> resultSets = searchCodeRepository.getEmployeeList(strCode);
         
               searchCodeList = SearchCodeResponseDto.copyList(resultSets);
         
          } catch(Exception exception) {
               exception.printStackTrace();
               return ResponseDto.databaseError();
          }

          return GetSearchCodeListResponseDto.success(searchCodeList);
     }

     @Override
     public ResponseEntity<? super GetSearchCodeListResponseDto> getDepartmentList(GetDepartmentDetailCodeRequestDto requestBody) {
          List<SearchCodeResponseDto> searchCodeList = null;
          Integer code = requestBody.getDepartmentCode();

          try{
               String strCode = code == null ? "" : Integer.toString(code);

               List<SearchCodeResultSet> resultSets = searchCodeRepository.getDepartmentList(strCode);
         
               searchCodeList = SearchCodeResponseDto.copyList(resultSets);
         
          } catch(Exception exception) {
               exception.printStackTrace();
               return ResponseDto.databaseError();
          }

          return GetSearchCodeListResponseDto.success(searchCodeList);
     }

     @Override
     public ResponseEntity<? super GetSearchCodeListResponseDto> getCustomerList(GetCustomerDetailCodeRequestDto requestBody) {
          List<SearchCodeResponseDto> searchCodeList = null;
          Integer code = requestBody.getCustomerCode();

          try{
               String strCode = code == null ? "" : Integer.toString(code);

               List<SearchCodeResultSet> resultSets = searchCodeRepository.getCustomerList(strCode);
         
               searchCodeList = SearchCodeResponseDto.copyList(resultSets);
         
          } catch(Exception exception) {
               exception.printStackTrace();
               return ResponseDto.databaseError();
          }

          return GetSearchCodeListResponseDto.success(searchCodeList);
     }

     @Override
     public ResponseEntity<? super GetSearchCodeListResponseDto> getProjecttList(GetProjectDetailCodeRequestDto requestBody) {
          List<SearchCodeResponseDto> searchCodeList = null;
          Integer code = requestBody.getSalesPlanCode();

          try{
               String strCode = code == null ? "" : Integer.toString(code);

               List<SearchCodeResultSet> resultSets = searchCodeRepository.getProjecttList(strCode);
         
               searchCodeList = SearchCodeResponseDto.copyList(resultSets);
         
          } catch(Exception exception) {
               exception.printStackTrace();
               return ResponseDto.databaseError();
          }

          return GetSearchCodeListResponseDto.success(searchCodeList);
     }
     
}
