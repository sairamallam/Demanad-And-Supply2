package com.hcl.supplymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.supplymanagementsystem.entity.DemandSkills;
import com.hcl.supplymanagementsystem.entity.Skill;
import java.util.List;
import com.hcl.supplymanagementsystem.entity.Demand;

public interface DemandSkillsRepository extends JpaRepository<DemandSkills, Long> {
	
public List<DemandSkills> findByDemand(Demand demand);
	
}
