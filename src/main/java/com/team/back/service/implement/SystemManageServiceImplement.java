package com.team.back.service.implement;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.back.dto.request.system.GetDepartmentListRequestDto;
import com.team.back.dto.request.system.PutCompanyInfoRequestDto;
import com.team.back.dto.request.system.PutCustomerInfoRequestDto;
import com.team.back.dto.request.system.PutDepartmentInfoRequestDto;
import com.team.back.dto.request.system.PutProductInfoRequestDto;
import com.team.back.dto.response.ResponseDto;
import com.team.back.dto.response.accounting.InvoiceResponseDto;
import com.team.back.dto.response.system.PutCompanyInfoResponseDto;
import com.team.back.dto.response.system.PutCustomerInfoResponseDto;
import com.team.back.dto.response.system.PutDepartmentInfoResponseDto;
import com.team.back.dto.response.system.PutProductInfoResponseDto;
import com.team.back.dto.response.system.CustomerListResponseDto;
import com.team.back.dto.response.system.DepartmentListResponseDto;
import com.team.back.dto.response.system.GetCompanyInfoResponseDto;
import com.team.back.dto.response.system.GetCustomerInfoResponseDto;
import com.team.back.dto.response.system.GetDepartmentInfoResponseDto;
import com.team.back.dto.response.system.GetProductInfoResponseDto;
import com.team.back.entity.CompanyEntity;
import com.team.back.entity.CustomerEntity;
import com.team.back.entity.DepartmentEntity;
import com.team.back.entity.ProductEntity;
import com.team.back.entity.CompanyEntity;
import com.team.back.entity.CustomerEntity;
import com.team.back.entity.DepartmentEntity;
import com.team.back.entity.InvoiceEntity;
import com.team.back.entity.resultSets.CustomerListResultSet;
import com.team.back.entity.resultSets.DepartmentListResultSet;
import com.team.back.repository.CompanyRepository;
import com.team.back.repository.CustomerRepository;
import com.team.back.repository.DepartmentRepository;
import com.team.back.repository.ProductRepository;
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
     private final ProductRepository productRepository;

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
     public ResponseEntity<? super PutDepartmentInfoResponseDto> putDepartmentInfo(Integer employeeCode, PutDepartmentInfoRequestDto dto) {
          String departmentName = dto.getDepartmentName();
          
          try{
               // description: 부서명 중복 확인
               boolean hasDeptName = departmentRepository.existsByDepartmentName(departmentName);
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
     public ResponseEntity<? super GetDepartmentInfoResponseDto> getDepartmentInfo(Integer employeeCode, GetDepartmentListRequestDto dto) {
          List<DepartmentListResponseDto> departmentList = null;
          String departmentName = dto.getDepartmentName();
          try{

               // description: 검색어가 부서명에 포함되어 있는 데이터 조회 //
               List<DepartmentListResultSet> departmentEntities = departmentRepository.getDepartmentList(departmentName);
         
               // description: entity를 dto형태로 변환 //
               departmentList = DepartmentListResponseDto.copyList(departmentEntities);
         
             } catch(Exception exception) {
               exception.printStackTrace();
               return ResponseDto.databaseError();
             }
             return GetDepartmentInfoResponseDto.success(departmentList);
     }

     @Override
     public ResponseEntity<? super GetCustomerInfoResponseDto> getCustomerInfo() {
          CustomerEntity customerEntity;

          try{
               // 데이터베이스에서 거래처 정보 불러오기 //
               customerEntity = customerRepository.findByCustomerCode(2000); 
          } catch(Exception exception){
               exception.printStackTrace();
               return ResponseDto.databaseError();
          }

          return GetCustomerInfoResponseDto.success(customerEntity);
     }

     @Override
     public ResponseEntity<? super PutCustomerInfoResponseDto> putCustomerInfo(Integer employeeCode, PutCustomerInfoRequestDto dto) {

          try{
            // 존재하는 사원번호인지 확인 //
            boolean hasUser = userRepository.existsByEmployeeCode(employeeCode);
            if(!hasUser) return PutCompanyInfoResponseDto.noExistedUser();
            // 권한 //
            if(employeeCode != 9999) return PutCompanyInfoResponseDto.noPermission();

            // entity 생성 //
            CustomerEntity customerEntity = new CustomerEntity(dto);
            
            // 데이터베이스에 저장 //
            customerRepository.save(customerEntity);
        } catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PutCustomerInfoResponseDto.success();

     }

     @Override
     public ResponseEntity<? super GetProductInfoResponseDto> getProductInfo() {

          ProductEntity productEntity;

          try{
               // 데이터베이스에서 품목 정보 불러오기 //
               productEntity = productRepository.findByProductCode(2000);
          } catch(Exception exception){
               exception.printStackTrace();
               return ResponseDto.databaseError();
          }

          return GetProductInfoResponseDto.success(productEntity);   

     }

     @Override
     public ResponseEntity<? super PutProductInfoResponseDto> putProductInfo(Integer employeeCode, PutProductInfoRequestDto dto) {

          try{
            // 존재하는 사원번호인지 확인 //
            boolean hasUser = userRepository.existsByEmployeeCode(employeeCode);
            if(!hasUser) return PutCompanyInfoResponseDto.noExistedUser();
            // 권한 //
            if(employeeCode != 9999) return PutCompanyInfoResponseDto.noPermission();

            // entity 생성 //
            ProductEntity productEntity = new ProductEntity(dto);
            
            // 데이터베이스에 저장 //
            productRepository.save(productEntity);
        } catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PutProductInfoResponseDto.success();


     }

     
}
