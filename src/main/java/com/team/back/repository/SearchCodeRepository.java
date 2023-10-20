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
     List<SearchCodeResultSet> getEmployeeList(String code);

     @Query(
          value=
               "SELECT ROW_NUMBER() OVER(ORDER BY department_code) AS no, department_code as detailCode, department_name as name " +
               "FROM department " +
               "WHERE department_code LIKE %?1% " +
               "AND department_name != 'SYSTEM'; ",
               nativeQuery=true 
     )
     List<SearchCodeResultSet> getDepartmentList(String code);

     @Query(
          value=
               "SELECT ROW_NUMBER() OVER(ORDER BY customer_code) AS no, customer_code as detailCode, customer_name as name " +
               "FROM customer " +
               "WHERE customer_code LIKE %?1% ",
               nativeQuery=true 
     )
     List<SearchCodeResultSet> getCustomerList(String code);

     @Query(
          value=
               "SELECT ROW_NUMBER() OVER(ORDER BY sales_plan_code) AS no, sales_plan_code as detailCode, project_name as name " +
               "FROM sales_plan " +
               "WHERE sales_plan_code LIKE %?1% ",
               nativeQuery=true 
     )
     List<SearchCodeResultSet> getProjecttList(String code);
}
