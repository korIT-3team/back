package com.team.back.service.implement;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.back.dto.request.searchView.GetEmployeeViewListRequestDto;
import com.team.back.dto.request.searchView.GetFundsListRequestDto;
import com.team.back.dto.request.searchView.GetIncentiveViewListRequestDto;
import com.team.back.dto.response.ResponseDto;
import com.team.back.dto.response.searchView.EmployeeViewResponseDto;
import com.team.back.dto.response.searchView.FundsResponseDto;
import com.team.back.dto.response.searchView.GetEmployeeViewListResponseDto;
import com.team.back.dto.response.searchView.GetFundsListResponseDto;
import com.team.back.dto.response.searchView.GetIncentiveViewListResponseDto;
import com.team.back.dto.response.searchView.IncentiveViewResponseDto;
import com.team.back.entity.EmployeeViewEntity;
import com.team.back.entity.FundsViewEntity;
import com.team.back.entity.IncentiveViewEntity;
import com.team.back.repository.EmployeeViewRepository;
import com.team.back.repository.FundsViewRepository;
import com.team.back.repository.IncentiveViewRepository;
import com.team.back.service.SearchViewService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SearchViewServiceImplement implements SearchViewService {
     
     private final FundsViewRepository fundsViewRepository;
     private final EmployeeViewRepository employeeViewRepository;
     private final IncentiveViewRepository incentiveViewRepository;

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

     @Override
     public ResponseEntity<? super GetEmployeeViewListResponseDto> getEmployeeViewList(GetEmployeeViewListRequestDto requestBody) {
          List<EmployeeViewResponseDto> employeeViewList = null;
          Integer emCode = requestBody.getEmployeeCode();
          Integer deCode = requestBody.getDepartmentCode();
          Integer type = requestBody.getEmploymentCode();

          try{ 
               String strEmCode = emCode == null ? "" : Integer.toString(emCode);
               String strDeCode = deCode == null ? "" : Integer.toString(deCode);
               String strType = type == null ? "" : Integer.toString(type);
               List<EmployeeViewEntity> EmployeeViewEntities = employeeViewRepository.getEmployeeViewList(strDeCode,strEmCode,strType);
               employeeViewList = EmployeeViewResponseDto.copyEntityList(EmployeeViewEntities);
               
          } catch(Exception exception){
               exception.printStackTrace();
               return ResponseDto.databaseError();
          }

          return GetEmployeeViewListResponseDto.success(employeeViewList);
     }

     @Override
     public ResponseEntity<? super GetIncentiveViewListResponseDto> getIncentiveViewList(GetIncentiveViewListRequestDto requestBody) {
          List<IncentiveViewResponseDto> incentiveViewList = null;
          Integer category = requestBody.getIncentiveCategory();
          String start = requestBody.getPaymentDateStart();
          String end = requestBody.getPaymentDateEnd();
          Integer emCode = requestBody.getEmployeeCode();

          try{ 
               String strCategory = category == null ? "" : Integer.toString(category);
               String strEmCode = emCode == null ? "" : Integer.toString(emCode);
               List<IncentiveViewEntity> incentiveViewEntities = incentiveViewRepository.getIncentiveViewList(strEmCode,strCategory,start,end);
               incentiveViewList = IncentiveViewResponseDto.copyEntityList(incentiveViewEntities);
               
          } catch(Exception exception){
               exception.printStackTrace();
               return ResponseDto.databaseError();
          }

          return GetIncentiveViewListResponseDto.success(incentiveViewList);

     }
}
