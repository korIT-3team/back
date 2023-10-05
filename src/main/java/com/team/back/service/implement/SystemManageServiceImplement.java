package com.team.back.service.implement;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.back.dto.request.system.PutCompanyInfoRequestDto;
import com.team.back.dto.request.system.PutDepartmentInfoRequestDto;
import com.team.back.dto.response.ResponseDto;
import com.team.back.dto.response.system.PutCompanyInfoResponseDto;
import com.team.back.dto.response.system.PutDepartmentInfoResponseDto;
import com.team.back.dto.response.system.CustomerListResponseDto;
import com.team.back.dto.response.system.DepartmentListResponseDto;
import com.team.back.dto.response.system.GetCompanyInfoResponseDto;
import com.team.back.dto.response.system.GetCustomerInfoResponseDto;
import com.team.back.dto.response.system.GetDepartmentInfoResponseDto;
import com.team.back.dto.response.system.GetSearchDepartmentInfoResponseDto;
import com.team.back.entity.CompanyEntity;
import com.team.back.entity.DepartmentEntity;
import com.team.back.entity.resultSets.CustomerListResultSet;
import com.team.back.entity.resultSets.DepartmentListResultSet;
import com.team.back.repository.CompanyRepository;
import com.team.back.repository.CustomerRepository;
import com.team.back.repository.DepartmentRepository;
import com.team.back.repository.UserRepository;
import com.team.back.service.SystemManageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SystemManageServiceImplement implements SystemManageService{
     
     private final CompanyRepository companyRepository;
     private final UserRepository userRepository;
     private final DepartmentRepository departmentRepository;
     private final CustomerRepository customerRepository;

     @Override
     public ResponseEntity<? super GetCompanyInfoResponseDto> getCompanyInfo() {
          
          CompanyEntity companyEntity;

          try{
               // 데이터베이스에서 회사정보 불러오기 //
               companyEntity = companyRepository.findByCompanyCode(1); 
          } catch(Exception exception){
               exception.printStackTrace();
               return ResponseDto.databaseError();
          }

          return GetCompanyInfoResponseDto.success(companyEntity);
     }

     @Override
     public ResponseEntity<? super PutCompanyInfoResponseDto> putCompanyInfo(Integer employeeCode, PutCompanyInfoRequestDto dto) {

        try{
            // 존재하는 사원번호인지 확인 //
            boolean hasUser = userRepository.existsByEmployeeCode(employeeCode);
            if(!hasUser) return PutCompanyInfoResponseDto.noExistedUser();
            // 권한 //
            if(employeeCode != 9999) return PutCompanyInfoResponseDto.noPermission();

            // entity 생성 //
            CompanyEntity companyEntity = new CompanyEntity(dto);
            
            // 데이터베이스에 저장 //
            companyRepository.save(companyEntity);
        } catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PutCompanyInfoResponseDto.success();
     }

     @Override
     public ResponseEntity<? super GetDepartmentInfoResponseDto> getDepartmentInfo() {
          
          List<DepartmentListResponseDto> departmentList = null;

          try{
               List<DepartmentListResultSet> resultSets = departmentRepository.getDepartmentList();
               departmentList = DepartmentListResponseDto.copyList(resultSets);
          } catch(Exception exception){
               exception.printStackTrace();
               return ResponseDto.databaseError();
          }
          return GetDepartmentInfoResponseDto.success(departmentList);
     }

     @Override
     public ResponseEntity<? super GetCustomerInfoResponseDto> getCustomerInfo() {

          List<CustomerListResponseDto> customerList = null;

          try {
               List<CustomerListResultSet> resultSets = customerRepository.getCustomerList();
               customerList = CustomerListResponseDto.copyList(resultSets);
          } catch (Exception exception) {
               exception.printStackTrace();
               return ResponseDto.databaseError();
          }
          return GetCustomerInfoResponseDto.success(customerList);

     }

     @Override
     public ResponseEntity<? super PutDepartmentInfoResponseDto> putDepartmentInfo(Integer employeeCode, PutDepartmentInfoRequestDto dto) {
          String departmentName = dto.getDepartmentName();
          
          try{
               // description: 부서명 중복 확인
               boolean hasDeptName = userRepository.existsByDepartmentName(departmentName);
               if (hasDeptName) return PutDepartmentInfoResponseDto.existedDeptname();

               // description: 존재하는 사원번호인지 확인 //
               boolean hasUser = userRepository.existsByEmployeeCode(employeeCode);
               if(!hasUser) return PutDepartmentInfoResponseDto.noExistedUser();

               // description:  권한 //
               if(employeeCode != 9999) return PutDepartmentInfoResponseDto.noPermission();

               // description:  Entity 생성 //
               DepartmentEntity departmentEntity = new DepartmentEntity(dto);
               
               // description:  DB에 저장 //
               
               departmentRepository.save(departmentEntity);

          } catch(Exception exception){
               // description: 데이터베이스 에러 //
               exception.printStackTrace();
               return ResponseDto.databaseError();
          }

        return PutDepartmentInfoResponseDto.success();
     }

     @Override
     public ResponseEntity<? super GetSearchDepartmentInfoResponseDto> getSearchDepartment(String departmentName) {
          List<DepartmentListResponseDto> departmentList = null;
          try{

               // description: 검색어가 부서명에 포함되어 있는 데이터 조회 //
               List<DepartmentListResultSet> departmentEntities = departmentRepository.findbyDepartmentList(departmentName);
         
               // description: entity를 dto형태로 변환 //
               departmentList = DepartmentListResponseDto.copyEntityList(departmentEntities);
         
             } catch(Exception exception) {
               exception.printStackTrace();
               return ResponseDto.databaseError();
             }
             return GetSearchDepartmentInfoResponseDto.success(departmentList);
     }

}
