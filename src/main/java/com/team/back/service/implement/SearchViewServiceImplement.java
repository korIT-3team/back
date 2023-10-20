package com.team.back.service.implement;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.back.dto.request.searchView.GetEmployeeViewListRequestDto;
import com.team.back.dto.request.searchView.GetFundsListRequestDto;
import com.team.back.dto.request.searchView.GetIncentiveViewListRequestDto;
import com.team.back.dto.response.ResponseDto;
import com.team.back.dto.response.searchView.EmployeeViewResponseDto;
import com.team.back.dto.response.searchView.EmploymentTypeResponseDto;
import com.team.back.dto.response.searchView.FundsResponseDto;
import com.team.back.dto.response.searchView.GetEmployeeViewListResponseDto;
import com.team.back.dto.response.searchView.GetEmploymentTypeListResponseDto;
import com.team.back.dto.response.searchView.GetFundsListResponseDto;
import com.team.back.dto.response.searchView.GetIncentiveTypeListResponseDto;
import com.team.back.dto.response.searchView.GetIncentiveViewListResponseDto;
import com.team.back.dto.response.searchView.IncentiveTypeResponseDto;
import com.team.back.dto.response.searchView.IncentiveViewResponseDto;
import com.team.back.entity.EmployeeViewEntity;
import com.team.back.entity.FundsViewEntity;
import com.team.back.entity.IncentiveViewEntity;
import com.team.back.entity.UserDefineDetailEntity;
import com.team.back.repository.EmployeeViewRepository;
import com.team.back.repository.FundsViewRepository;
import com.team.back.repository.IncentiveViewRepository;
import com.team.back.repository.UserDefineDetailRepository;
import com.team.back.service.SearchViewService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SearchViewServiceImplement implements SearchViewService {
     
     private final FundsViewRepository fundsViewRepository;
     private final EmployeeViewRepository employeeViewRepository;
     private final IncentiveViewRepository incentiveViewRepository;
     private final UserDefineDetailRepository userDefineDetailRepository;

     @Override
     public ResponseEntity<? super GetEmploymentTypeListResponseDto> getEmploymentType() {
          List<EmploymentTypeResponseDto> employmentTypeList = null;
          try{
               List<UserDefineDetailEntity> employmentTypeEntities = userDefineDetailRepository.getEmploymentType();
               
               employmentTypeList = EmploymentTypeResponseDto.copyEntityList(employmentTypeEntities);

          } catch(Exception exception){
               exception.printStackTrace();
               return ResponseDto.databaseError();
          }

          return GetEmploymentTypeListResponseDto.success(employmentTypeList);
     }

     @Override
     public ResponseEntity<? super GetIncentiveTypeListResponseDto> getIncentiveType() {
          List<IncentiveTypeResponseDto> incentiveTypeList = null;
          try{
               List<UserDefineDetailEntity> employmentTypeEntities = userDefineDetailRepository.getIncentiveType();
               
               incentiveTypeList = IncentiveTypeResponseDto.copyEntityList(employmentTypeEntities);

          } catch(Exception exception){
               exception.printStackTrace();
               return ResponseDto.databaseError();
          }

          return GetIncentiveTypeListResponseDto.success(incentiveTypeList);
     }

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
          String type = requestBody.getEmploymentType() == null ? "" :  requestBody.getEmploymentType() ;

          try{ 
               String strEmCode = emCode == null ? "" : Integer.toString(emCode);
               String strDeCode = deCode == null ? "" : Integer.toString(deCode);
               List<EmployeeViewEntity> EmployeeViewEntities = employeeViewRepository.getEmployeeViewList(strDeCode,strEmCode,type);
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
          String category = requestBody.getIncentiveCategoryName() == null ? "" : requestBody.getIncentiveCategoryName();
          String start = requestBody.getPaymentDateStart();
          String end = requestBody.getPaymentDateEnd();
          Integer emCode = requestBody.getEmployeeCode();

          try{ 
               String strEmCode = emCode == null ? "" : Integer.toString(emCode);
               List<IncentiveViewEntity> incentiveViewEntities = incentiveViewRepository.getIncentiveViewList(strEmCode, category, start, end);
               incentiveViewList = IncentiveViewResponseDto.copyEntityList(incentiveViewEntities);
               
          } catch(Exception exception){
               exception.printStackTrace();
               return ResponseDto.databaseError();
          }

          return GetIncentiveViewListResponseDto.success(incentiveViewList);

     }
}
