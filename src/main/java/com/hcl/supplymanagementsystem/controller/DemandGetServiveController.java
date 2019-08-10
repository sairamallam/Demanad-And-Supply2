package com.hcl.supplymanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.supplymanagementsystem.dto.DemandsGetDto;
import com.hcl.supplymanagementsystem.dto.ResourceMatchData;
import com.hcl.supplymanagementsystem.entity.Resources;
import com.hcl.supplymanagementsystem.service.DemandGetService;


@CrossOrigin("*")
@RequestMapping("/demand")
@RestController
public class DemandGetServiveController  {
	
	
	@Autowired DemandGetService demandGetService;
	
	
	@GetMapping("/demands")
	public List<DemandsGetDto> getDemands() {
		return demandGetService.getDemands();
	}
	
	@GetMapping("/demands/{id}")
	public ResourceMatchData getDemandsById(@PathVariable("id") Long id) {
		return demandGetService.getDemandsResources(id);
	}

}
