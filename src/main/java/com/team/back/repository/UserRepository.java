package com.team.back.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.back.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
     boolean existsByEmployeeCode(Integer employeeCode);
     UserEntity findByEmployeeCode(Integer employeeCode);
}
