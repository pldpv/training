package com.marakana.contacts.entities;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Calibration extends CheckInstrument{

	public Calibration() {
	}

	public Calibration(Organization organization, Date currentCheck,
			Long periodicity, Date nextCheck, Float actualCost,
			boolean isChecked) {
		super(organization, currentCheck, periodicity, nextCheck, actualCost, isChecked);
	}
	
	
}
