package com.hcl.supplymanagementsystem.dto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.supplymanagementsystem.entity.ResourceSkills;
import com.hcl.supplymanagementsystem.entity.Resources;

public interface ResourceSkillsRepository extends JpaRepository<ResourceSkills, Long> {

public	List<ResourceSkills> findByResources(Resources resources);
  	
}
