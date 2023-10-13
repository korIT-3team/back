package com.team.back.service.implement;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.back.dto.request.accounting.GetInOutComeListRequestDto;
import com.team.back.dto.request.accounting.GetInvoiceDetailRequestDto;
import com.team.back.dto.request.accounting.GetInvoiceListRequestDto;
import com.team.back.dto.response.ResponseDto;
import com.team.back.dto.response.accounting.GetInOutComeListResponseDto;
import com.team.back.dto.response.accounting.GetInvoiceDetailIncentiveInfoResponseDto;
import com.team.back.dto.response.accounting.GetInvoiceDetailOrderInfoResponseDto;
import com.team.back.dto.response.accounting.GetInvoiceDetailSalesInfoResponseDto;
import com.team.back.dto.response.accounting.GetInvoiceListResponseDto;
import com.team.back.dto.response.accounting.InOutComeResponseDto;
import com.team.back.dto.response.accounting.InvoiceResponseDto;
import com.team.back.entity.FundsViewEntity;
import com.team.back.entity.IncentiveViewEntity;
import com.team.back.entity.InvoiceEntity;
import com.team.back.entity.OrderViewEntity;
import com.team.back.entity.SalesViewEntity;
import com.team.back.repository.FundsViewRepository;
import com.team.back.repository.IncentiveViewRepository;
import com.team.back.repository.InvoiceRepository;
import com.team.back.repository.OrderViewRepository;
import com.team.back.repository.SalesViewRepository;
import com.team.back.repository.UserRepository;
import com.team.back.service.AccountingService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountingServiceImplement implements AccountingService {
     
     private final InvoiceRepository invoiceRepository;
     private final OrderViewRepository orderViewRepository;
     private final SalesViewRepository salesViewRepository;
     private final IncentiveViewRepository incentiveViewRepository;
     private final FundsViewRepository fundsViewRepository;
     private final UserRepository userRepository;
     
     @Override
     public ResponseEntity<? super GetInvoiceListResponseDto> getInvoiceList(GetInvoiceListRequestDto dto) {
          List<InvoiceResponseDto> invoiceList = null;
          Integer emCode = dto.getEmployeeCode();
          Integer deCode = dto.getDepartmentCode();
          String start = dto.getInvoiceDateStart();
          String end = dto.getInvoiceDateEnd();
          Integer type = dto.getInvoiceType();
          
          try{
               // description : string으로 변환시키지않으면, "null" 문자열이 들어가게 된다.
               String strEmCode = emCode == null ? "" : Integer.toString(emCode);
               String strDeCode = deCode == null ? "" : Integer.toString(deCode);
               String strType = type == null ? "" : Integer.toString(type);
               // String emName = 
               
               // description : db 조회
               List<InvoiceEntity> invoiceEntities = invoiceRepository.getInvoiceList(strEmCode, strDeCode, start, end, strType);
               
               // description : entity 를 dto 로 변환 //
               invoiceList = InvoiceResponseDto.copyEntityList(invoiceEntities);

          } catch(Exception exception){
               exception.printStackTrace();
               return ResponseDto.databaseError();
          }

          return GetInvoiceListResponseDto.success(invoiceList);
     }

     @Override
     public ResponseEntity<? super InvoiceResponseDto> getInvoiceDetail(Integer invoiceCode) {
          InvoiceEntity invoiceEntity;
          try{ 
               // description : 선택된 해당 전표 번호의 데이터를 가져옴 //
               invoiceEntity = invoiceRepository.findByInvoiceCode(invoiceCode);
               if(invoiceEntity == null) return InvoiceResponseDto.noExistedInvoice();
          } catch(Exception exception){
               exception.printStackTrace();
               return ResponseDto.databaseError();
          }
          return InvoiceResponseDto.success(invoiceEntity);
     }

     @Override
     public ResponseEntity<? super GetInvoiceDetailOrderInfoResponseDto> getInvoiceDetailOrderInfo(GetInvoiceDetailRequestDto requestBody) {
          OrderViewEntity orderViewEntity;
          try{ 
               // description : 수주 번호로 데이터 조회 //
               orderViewEntity = orderViewRepository.findByOrderCode(requestBody.getPrimaryKey());
               if(orderViewEntity == null) return GetInvoiceDetailOrderInfoResponseDto.noExistedInvoice();
          } catch(Exception exception){
               exception.printStackTrace();
               return ResponseDto.databaseError();
          }

          return GetInvoiceDetailOrderInfoResponseDto.success(orderViewEntity);
     }

     @Override
     public ResponseEntity<? super GetInvoiceDetailSalesInfoResponseDto> getInvoiceDetailSalesInfo(GetInvoiceDetailRequestDto requestBody) {
          SalesViewEntity salesViewEntity;
          try{ 
               // description : 매출 번호로 데이터 조회 //
               salesViewEntity = salesViewRepository.findBySalesCode(requestBody.getPrimaryKey());
               if(salesViewEntity == null) return GetInvoiceDetailSalesInfoResponseDto.noExistedInvoice();
          } catch(Exception exception){
               exception.printStackTrace();
               return ResponseDto.databaseError();
          }

          return GetInvoiceDetailSalesInfoResponseDto.success(salesViewEntity);
     }

     @Override
     public ResponseEntity<? super GetInvoiceDetailIncentiveInfoResponseDto> getInvoiceDetailIncentiveInfo(GetInvoiceDetailRequestDto requestBody) {
          IncentiveViewEntity incentiveViewEntity;
          try{ 
               // description : 급/상여 코드로 데이터 조회 //
               incentiveViewEntity = incentiveViewRepository.findByIncentiveCode(requestBody.getPrimaryKey());
               if(incentiveViewEntity == null) return GetInvoiceDetailIncentiveInfoResponseDto.noExistedInvoice();
          } catch(Exception exception){
               exception.printStackTrace();
               return ResponseDto.databaseError();
          }

          return GetInvoiceDetailIncentiveInfoResponseDto.success(incentiveViewEntity);
     }

     @Override
     public ResponseEntity<? super GetInOutComeListResponseDto> getInOutComeList(GetInOutComeListRequestDto requestBody) {
          List<InOutComeResponseDto> inOutComeList = null;
          String start = requestBody.getFundDateStart();
          String end = requestBody.getFundDateEnd();
          Integer cmCode = requestBody.getCustomerCode();
          Integer spCode = requestBody.getSalesPlanCode();

          try{ 
               String strCmCode = cmCode == null ? "" : Integer.toString(cmCode);
               String strSpCode = spCode == null ? "" : Integer.toString(spCode);
               
               List<FundsViewEntity> fundsViewEntities = fundsViewRepository.getInOutComeList(strCmCode, strSpCode, start, end);
               inOutComeList = InOutComeResponseDto.copyEntityList(fundsViewEntities);
               
          } catch(Exception exception){
               exception.printStackTrace();
               return ResponseDto.databaseError();
          }

          return GetInOutComeListResponseDto.success(inOutComeList);
     };
}
