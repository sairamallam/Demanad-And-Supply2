package com.hcl.supplymanagementsystem.dto;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.supplymanagementsystem.entity.Resources;

public interface ResourcesRepository extends JpaRepository<Resources, Long> {

}
