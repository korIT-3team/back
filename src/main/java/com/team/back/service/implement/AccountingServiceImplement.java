package com.team.back.service.implement;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.team.back.dto.request.accounting.GetInvoiceListRequestDto;
import com.team.back.dto.response.ResponseDto;
import com.team.back.dto.response.accounting.GetInvoiceListResponseDto;
import com.team.back.dto.response.accounting.InvoiceResponseDto;

import com.team.back.entity.InvoiceEntity;
import com.team.back.repository.InvoiceRepository;
import com.team.back.service.AccountingService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountingServiceImplement implements AccountingService {
     
     private final InvoiceRepository invoiceRepository;
     
     @Override
     public ResponseEntity<? super GetInvoiceListResponseDto> getInvoiceList(Integer employeeCode, GetInvoiceListRequestDto dto) {
          List<InvoiceResponseDto> invoiceList = null;
          int emCode = dto.getEmployeeCode();
          int deCode = dto.getDepartmentCode();
          String start = dto.getInvoiceDateStart();
          String end = dto.getInvoiceDateEnd();
          int type = dto.getInvoiceType();
          

          try{
               List<InvoiceEntity> invoiceEntities = invoiceRepository.getInvoiceList(emCode, deCode, start, end, type);
               
               // description : entity 를 dto 로 변환 //
               invoiceList = InvoiceResponseDto.copyEntityList(invoiceEntities);

               // invoiceList = invoiceRepository.getInvoiceList(dto);
               // invoiceList = InvoiceResponseDto.copyList(resultSets);

          } catch(Exception exception){
               exception.printStackTrace();
               return ResponseDto.databaseError();
          }

          return GetInvoiceListResponseDto.success(invoiceList);
     }
}
