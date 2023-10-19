package com.team.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.team.back.entity.IncentiveViewEntity;

@Repository
public interface IncentiveViewRepository extends JpaRepository<IncentiveViewEntity, Integer>   {
     IncentiveViewEntity findByIncentiveCode(Integer incentiveCode);
     
     @Query(
          value=
               "SELECT * " +
               "from incentive_view " +
               "where payment_date BETWEEN ?3 AND ?4 " +
               "AND incentive_category_name LIKE %?2% " +
               "AND employee_code LIKE %?1%; ",
               nativeQuery=true 
     )
     List<IncentiveViewEntity> getIncentiveViewList(String employeeCode, String category, String dateStart, String dateEnd);
}
