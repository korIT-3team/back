package com.team.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.back.entity.SystemEmployeeEntity;

@Repository
public interface HumanDetailRepository extends JpaRepository<SystemEmployeeEntity, Integer>   {
  SystemEmployeeEntity findByEmployeeCode(Integer employeeCode);
}
