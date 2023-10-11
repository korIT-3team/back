package com.team.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.team.back.entity.InOutComeViewEntity;

@Repository
public interface InOutComeViewRepository extends JpaRepository<InOutComeViewEntity, Integer> {
     InOutComeViewEntity findByFundingCode(Integer fundingCode);
     @Query(
          value=
               "SELECT * " +
               "from inout_come_view " +
               "where fund_date BETWEEN ?3 AND ?4 " +
               "AND sales_plan_code LIKE %?2% " +
               "AND customer_code LIKE %?1%; ",
               nativeQuery=true 
     )
     List<InOutComeViewEntity> getInOutComeList(String customerCode, String salesPlanCode, String invoiceDateStart, String invoiceDateEnd);
}