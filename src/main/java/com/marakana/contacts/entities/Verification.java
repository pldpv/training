package com.marakana.contacts.entities;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Verification extends CheckInstrument {

	public Verification() {
	}

	public Verification(Organization organization, Date currentCheck,
			Long periodicity, Date nextCheck, Float actualCost,
			boolean isChecked) {
		super(organization, currentCheck, periodicity, nextCheck, actualCost, isChecked);
	}

}
