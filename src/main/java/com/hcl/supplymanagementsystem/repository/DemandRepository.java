package com.hcl.supplymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.supplymanagementsystem.entity.Demand;

@Repository
public interface DemandRepository extends JpaRepository<Demand, Long>{

}
