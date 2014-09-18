package com.marakana.contacts.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Organization extends BaseEntity {

	public Organization() {
	}

	public Organization(String name, String checkType,
			Set<CheckInstrument> checkInstrument) {
		this.name = name;
		this.checkType = checkType;
		this.checkInstrument = checkInstrument;
	}

	@Column
	private String name;
	@Column
	private String checkType;
	@OneToMany(mappedBy = "organization")
	private Set<CheckInstrument> checkInstrument;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCheckType() {
		return checkType;
	}

	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}

	public Set<CheckInstrument> getCheckInstrument() {
		return checkInstrument;
	}

	public void setCheckInstrument(Set<CheckInstrument> checkInstrument) {
		this.checkInstrument = checkInstrument;
	}
}
