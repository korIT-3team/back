package com.team.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.team.back.entity.InvoiceEntity;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Integer> {

     @Query(
          value=
               "SELECT *" +
               "FROM invoice " +
               "WHERE invoice_type LIKE '%?5 %' " +
               "AND invoice_date BETWEEN '?3 ' AND '?4 ' " +
               "AND worker_code LIKE '%?2 %' " +
               "AND worker_department_code LIKE '%?1 %';",
               nativeQuery=true 
     )
     List<InvoiceEntity> getInvoiceList(int departmentCode, int employeeCode, String invoiceDateStart, String invoiceDateEnd, int invoiceType);
}
