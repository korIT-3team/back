package com.team.back.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.back.entity.SystemEmployeeEntity;

@Repository
public interface UserRepository extends JpaRepository<SystemEmployeeEntity, Integer> {
     boolean existsByEmployeeCode(Integer employeeCode);
     SystemEmployeeEntity findByEmployeeCode(Integer employeeCode);
}
