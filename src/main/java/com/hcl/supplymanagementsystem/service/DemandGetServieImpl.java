package com.hcl.supplymanagementsystem.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.supplymanagementsystem.dto.DemandsGetDto;
import com.hcl.supplymanagementsystem.dto.ResourceMatchData;
import com.hcl.supplymanagementsystem.dto.ResourceSkillsRepository;
import com.hcl.supplymanagementsystem.dto.ResourcesRepository;
import com.hcl.supplymanagementsystem.entity.Demand;
import com.hcl.supplymanagementsystem.entity.DemandSkills;
import com.hcl.supplymanagementsystem.entity.ResourceSkills;
import com.hcl.supplymanagementsystem.entity.Resources;
import com.hcl.supplymanagementsystem.entity.Skill;
import com.hcl.supplymanagementsystem.repository.DemandRepository;
import com.hcl.supplymanagementsystem.repository.DemandSkillsRepository;

@Service
public class DemandGetServieImpl implements DemandGetService {

	@Autowired
	DemandSkillsRepository demandSkillsRepository;
	@Autowired
	DemandRepository demandRepository;
	@Autowired
	ResourcesRepository resourcesRepository;
	@Autowired
	ResourceSkillsRepository resourceSkillsRepository;

	@Override
	public List<DemandsGetDto> getDemands() {

		List<Demand> demandist = demandRepository.findAll();
		List<DemandsGetDto> demandsGetDtolist = new ArrayList<>();

		for (Demand demand : demandist) {

			List<DemandSkills> demandSkillslist = demandSkillsRepository.findByDemand(demand);

			DemandsGetDto demandsGetDto2 = new DemandsGetDto();

			demandsGetDto2.setDemandId(demand.getDemandId());

			List<Skill> skilllist = new ArrayList<>();

			for (DemandSkills demandSkills : demandSkillslist) {

				skilllist.add(demandSkills.getSkill());

				demandsGetDtolist.add(demandsGetDto2);

			}

			demandsGetDto2.setSkill(skilllist);

		}

		return demandsGetDtolist;

	}

	@Override
	public ResourceMatchData getDemandsResources(Long demandId) {

		Demand demand = new Demand();
		demand.setDemandId(demandId);

		List<DemandSkills> demandSkillslist = demandSkillsRepository.findByDemand(demand);

		List<Resources> resourceslist = resourcesRepository.findAll();

		Map<Long,Integer> resourceMap=new  HashMap<>();
		
		for (Resources resources : resourceslist) {

			List<ResourceSkills> resourceSkillslist = resourceSkillsRepository.findByResources(resources);

			resourceMap.put(resources.getResourcesId(), 0);
			
			for (DemandSkills demandSkills : demandSkillslist) {

				for (ResourceSkills resourceSkills : resourceSkillslist) {
					
					if(demandSkills.getSkill().getSkillId().equals(resourceSkills.getSkill().getSkillId())) {
						
						Integer id = resourceMap.get(resources.getResourcesId());
						
						id++;
						resourceMap.replace(resources.getResourcesId(), id);
						
						
					}
					

					
//					

				}

			}

		}
//		Map<Long,Integer> resourceFinal=new HashMap<>();
//		List li=new ArrayList<>();
		
		Long id=0L;
		int count=0;
		
		ResourceMatchData resourceMatchData=new ResourceMatchData();
		
		for (Resources resources2 : resourceslist) {
			
			Integer val = resourceMap.get(resources2.getResourcesId());
			
			if(val>count) {
				
				count=val;
				id=resources2.getResourcesId();
			}
			
		}
		
		
		
		
		if(demandSkillslist.size()==count) {
			//exactly match
			
			System.out.println("exactly");
			
			
			resourceMatchData.setStatus("1");
			resourceMatchData.setResources(resourcesRepository.findById(id).get());
			 return resourceMatchData;
			
			
		}else {
			
			//not exactly match
			
			System.out.println("aprtial ");
			
			resourceMatchData.setStatus("0");
			resourceMatchData.setResources(resourcesRepository.findById(id).get());
			
			return resourceMatchData;
				 

			
		}

	}

}
