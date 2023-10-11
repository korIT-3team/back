package com.team.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.back.entity.IncentiveViewEntity;

@Repository
public interface IncentiveViewRepository extends JpaRepository<IncentiveViewEntity, Integer>   {
     IncentiveViewEntity findByIncentiveCode(Integer incentiveCode);
}
