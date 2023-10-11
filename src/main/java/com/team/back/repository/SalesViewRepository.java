package com.team.back.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.back.entity.SalesViewEntity;

@Repository
public interface SalesViewRepository extends JpaRepository<SalesViewEntity, Integer>   {
     SalesViewEntity findBySalesCode(Integer salesCode);
}
