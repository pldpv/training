package com.marakana.contacts.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class CheckInstrument extends BaseEntity{
	public CheckInstrument(){}
	public CheckInstrument(Organization organization, Date currentCheck,
			Long periodicity, Date nextCheck, Float actualCost,
			boolean isChecked) {
		this.organization = organization;
		this.currentCheck = currentCheck;
		this.periodicity = periodicity;
		this.nextCheck = nextCheck;
		this.actualCost = actualCost;
		this.isChecked = isChecked;
	}
	@ManyToOne
	private Organization organization;
	@Column
	private Date currentCheck;
	@Column
	private Long periodicity;
	//TODO create formula for calculate nextCheck
	@Column
	private Date nextCheck;
	@Column
	private Float actualCost;
	//TODO create formula for calculate isChecked
	@Column
	private boolean isChecked;
	public Organization getOrganization() {
		return organization;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	public Date getCurrentCheck() {
		return currentCheck;
	}
	public void setCurrentCheck(Date currentCheck) {
		this.currentCheck = currentCheck;
	}
	public Long getPeriodicity() {
		return periodicity;
	}
	public void setPeriodicity(Long periodicity) {
		this.periodicity = periodicity;
	}
	public Date getNextCheck() {
		return nextCheck;
	}
	public void setNextCheck(Date nextCheck) {
		this.nextCheck = nextCheck;
	}
	public Float getActualCost() {
		return actualCost;
	}
	public void setActualCost(Float actualCost) {
		this.actualCost = actualCost;
	}
	public boolean isChecked() {
		return isChecked;
	}
	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}
	
}
