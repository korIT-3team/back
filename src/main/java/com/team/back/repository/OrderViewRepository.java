package com.team.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.back.entity.OrderViewEntity;

@Repository
public interface OrderViewRepository extends JpaRepository<OrderViewEntity, Integer>  {
     OrderViewEntity findByOrderCode(Integer orderCode);
}
