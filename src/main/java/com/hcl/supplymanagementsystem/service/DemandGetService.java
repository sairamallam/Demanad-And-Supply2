package com.hcl.supplymanagementsystem.service;

import java.util.List;

import com.hcl.supplymanagementsystem.dto.DemandsGetDto;
import com.hcl.supplymanagementsystem.dto.ResourceMatchData;
import com.hcl.supplymanagementsystem.entity.Resources;

public interface DemandGetService {
	
	public List<DemandsGetDto> getDemands();
	
	public ResourceMatchData getDemandsResources(Long demandId);


}
