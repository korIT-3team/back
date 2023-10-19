package com.team.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.team.back.entity.EmptyEntity;
import com.team.back.entity.resultSets.SearchCodeResultSet;

@Repository
public interface SearchCodeRepository extends JpaRepository<EmptyEntity, Integer> {
      @Query(
          value=
               "SELECT ROW_NUMBER() OVER(ORDER BY employee_code) AS no, employee_code as detailCode, employee_name as name " +
               "FROM employee " +
               "WHERE employee_code LIKE %?1% " +
               "AND employee_name != 'system'; ",
               nativeQuery=true 
     )
     List<SearchCodeResultSet> getEmployeeList(String employeeCode);
}
