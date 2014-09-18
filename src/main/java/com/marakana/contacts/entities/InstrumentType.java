package com.marakana.contacts.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class InstrumentType extends BaseEntity {
	
	public InstrumentType() {
	}

	public InstrumentType(String instrumentType,
			InstrumentCategory instrumentCategory, SphereOfUse sphereOfUse,
			Set<InstrumentModel> instrumentModel) {
		super();
		this.instrumentType = instrumentType;
		this.instrumentCategory = instrumentCategory;
		this.sphereOfUse = sphereOfUse;
		this.instrumentModel = instrumentModel;
	}

	@Column
	private String instrumentType;
	
	@ManyToOne
	private InstrumentCategory instrumentCategory;
	
	@ManyToOne
	private SphereOfUse sphereOfUse;
	
	@OneToMany(mappedBy="instrumentType")
	private Set<InstrumentModel> instrumentModel;
	
	public String getInstrumentType() {
		return instrumentType;
	}

	public void setInstrumentType(String instrumentType) {
		this.instrumentType = instrumentType;
	}

	public InstrumentCategory getInstrumentCategory() {
		return instrumentCategory;
	}

	public void setInstrumentCategory(InstrumentCategory instrumentCategory) {
		this.instrumentCategory = instrumentCategory;
	}

	public SphereOfUse getSphereOfUse() {
		return sphereOfUse;
	}

	public void setSphereOfUse(SphereOfUse sphereOfUse) {
		this.sphereOfUse = sphereOfUse;
	}
	public Set<InstrumentModel> getInstrumentModel() {
		return instrumentModel;
	}

	public void setInstrumentModel(Set<InstrumentModel> instrumentModel) {
		this.instrumentModel = instrumentModel;
	}
}
