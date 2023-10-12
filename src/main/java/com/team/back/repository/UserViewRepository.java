package com.team.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.team.back.entity.UserViewEntity;

@Repository
public interface UserViewRepository extends JpaRepository<UserViewEntity, Integer> {
     UserViewEntity findByEmployeeCode(Integer employeeCode);
     @Query(
          value=
               "select e.department_code " +
               "from employee e, department d " +
               "WHERE e.department_code = d.department_code " +
               "and e.employee_code = ?1 ; ",
               nativeQuery=true 
     )
     Integer getUserDepartMentCode(Integer employeeCode);
}
