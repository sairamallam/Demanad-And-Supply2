package com.hcl.supplymanagementsystem.dto;

import com.hcl.supplymanagementsystem.entity.Resources;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class ResourceMatchData {
	
	private String status;
	private Resources resources;

}
