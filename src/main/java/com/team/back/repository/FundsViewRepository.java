package com.team.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.team.back.entity.FundsViewEntity;

@Repository
public interface FundsViewRepository extends JpaRepository<FundsViewEntity, Integer> {
     FundsViewEntity findByFundingCode(Integer fundingCode);
     @Query(
          value=
               "SELECT * " +
               "from funds_view " +
               "where fund_date BETWEEN ?3 AND ?4 " +
               "AND sales_plan_code LIKE %?2% " +
               "AND customer_code LIKE %?1% " +
               "AND customer_code NOT LIKE '0'; ",
               nativeQuery=true 
     )
     List<FundsViewEntity> getInOutComeList(String customerCode, String salesPlanCode, String invoiceDateStart, String invoiceDateEnd);
     
     @Query(
          value=
               "SELECT * " +
               "from funds_view " +
               "where fund_date BETWEEN ?1 AND ?2 ; ",
               nativeQuery=true 
     )
     List<FundsViewEntity> getFundsList(String invoiceDateStart, String invoiceDateEnd);
}