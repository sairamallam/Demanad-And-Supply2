package com.hcl.supplymanagementsystem.dto;

import java.util.List;

import com.hcl.supplymanagementsystem.entity.Skill;

import lombok.Getter;
import lombok.Setter;


@Setter @Getter
public class DemandsGetDto {
	
	private Long demandId;
	private List<Skill> skill;

}
