package com.hcl.supplymanagementsystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Training {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long  trainingId;
	
	@ManyToOne
	@JoinColumn(name = "resourcesId")
	private Resources resources;
	
	@ManyToOne
	@JoinColumn(name = "demand_id")
	private Demand demand;
	
	
	@ManyToOne @JoinColumn(name = "skill_id")
	private Skill skill;


}
