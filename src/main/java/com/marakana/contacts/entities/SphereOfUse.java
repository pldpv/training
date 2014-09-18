package com.marakana.contacts.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class SphereOfUse extends BaseEntity {
	@Column
	private String sphereOfUse;

	public SphereOfUse() {
	}
	public SphereOfUse(String sphereOfUse, Set<InstrumentType> instrumenTypet) {
		this.sphereOfUse = sphereOfUse;
		this.instrumenTypet = instrumenTypet;
	}


	@OneToMany(mappedBy = "sphereOfUse")
	private Set<InstrumentType> instrumenTypet;

	public String getSphereOfUse() {
		return sphereOfUse;
	}

	public void setSphereOfUse(String sphereOfUse) {
		this.sphereOfUse = sphereOfUse;
	}
	public Set<InstrumentType> getInstrumenTypet() {
		return instrumenTypet;
	}
	public void setInstrumenTypet(Set<InstrumentType> instrumenTypet) {
		this.instrumenTypet = instrumenTypet;
	}
	
}
