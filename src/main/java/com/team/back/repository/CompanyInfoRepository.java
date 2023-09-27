package com.team.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.back.entity.CompanyEntity;

@Repository
public interface CompanyInfoRepository extends JpaRepository<CompanyEntity, Integer> {
     
}
