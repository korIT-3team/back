package com.team.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.back.entity.EmployeeEntity;

@Repository
public interface MainRepository extends JpaRepository<EmployeeEntity, Integer> {
     boolean existsByEmployeeCode(Integer employeeCode);
}
