package com.team.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.team.back.entity.IncentiveEntity;
import com.team.back.entity.resultSets.IncentiveListResultSet;

@Repository
public interface IncentiveRepository extends JpaRepository<IncentiveEntity, Integer> {

      IncentiveEntity findByIncentiveCode(Integer incentiveCode);
       @Query(
          value=
          "SELECT ROW_NUMBER() OVER(ORDER BY I.incentive_code) AS no, " +
          "I.incentive_code AS incentiveCode, " +
          "E.employee_name AS employeeName, " +
          "I.employee_code AS employeeCode, " +
          "UDD.user_define_detail_name AS incentiveCategoryName, " +
          "I.incentive_category AS incentiveCategoryCode, " +
          "I.payment_date AS paymentDate, " +
          "I.incentive_price AS incentivePrice, " +
          "I.content AS content " +
          "FROM incentive AS I " +
          "LEFT OUTER JOIN employee AS E ON I.employee_code = E.employee_code " +
          "LEFT OUTER JOIN user_define_detail AS UDD ON I.incentive_category = UDD.user_define_detail_code AND UDD.user_define_code = 9008 " +
          "WHERE (?1 = 0 OR (I.employee_code != 0 AND I.employee_code = ?1)) " +
            "AND (?2 = 0 OR (I.incentive_category != 0 AND I.incentive_category = ?2)) " +
          "ORDER BY I.employee_code;" ,
          nativeQuery=true 
     )
     List<IncentiveListResultSet> getIncentiveList(String employeeCode, String incentiveCategory);
}
