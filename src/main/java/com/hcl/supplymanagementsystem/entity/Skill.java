package com.hcl.supplymanagementsystem.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Skill implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long skillId;
	
	private String skillName;
//	private String group;

//	@OneToOne
//	@JoinColumn(name = "skill_group")
//	SkillGroup skillGroup;

}
