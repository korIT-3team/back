package com.team.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.team.back.entity.InvoiceViewEntity;

public interface InvoiceViewRepository extends JpaRepository<InvoiceViewEntity, Integer> {
     
     InvoiceViewEntity findByInvoiceCode(Integer invoiceCode);
     @Query(
          value=
               "SELECT * " +
               "FROM invoice_view " +
               "WHERE invoice_type_name LIKE %?5% " +
               "AND invoice_date BETWEEN ?3 AND ?4 " +
               "AND worker_code LIKE %?2% " +
               "AND worker_department_code LIKE %?1% " +
               "ORDER BY invoice_code; ",
               nativeQuery=true 
     )
     List<InvoiceViewEntity> getInvoiceList(String departmentCode, String employeeCode, String invoiceDateStart, String invoiceDateEnd, String invoiceType);
}
