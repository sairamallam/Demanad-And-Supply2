package com.hcl.supplymanagementsystem.entity;

import java.io.Serializable;

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
public class DemanadAllocation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long demanadAllocationId;

	@ManyToOne
	@JoinColumn(name = "resources_id")
	private Resources resources;

	@ManyToOne
	@JoinColumn(name = "demand_id")
	private Demand demand;
	


}
