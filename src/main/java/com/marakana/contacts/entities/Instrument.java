package com.marakana.contacts.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Instrument extends BaseEntity {
	public Instrument() {
	}

	public Instrument(Long serialNumbet, Date receiptDate, String location,
			Date productionYear, Department department,
			InstrumentModel instrumentModel, Calibration calibration,
			Verification verification, TechnicalState technicalState) {
		super();
		this.serialNumbet = serialNumbet;
		this.receiptDate = receiptDate;
		this.location = location;
		this.productionYear = productionYear;
		this.department = department;
		this.instrumentModel = instrumentModel;
		this.calibration = calibration;
		this.verification = verification;
		this.technicalState = technicalState;
	}

	@Column
	private Long serialNumbet;
	@Column
	private Date receiptDate;
	@Column
	private String location;
	@Column
	private Date productionYear;
	@ManyToOne
	private Department department;

	@ManyToOne
	private InstrumentModel instrumentModel;
	@ManyToOne
	private Calibration calibration;
	@ManyToOne
	private Verification verification;
	@ManyToOne
	private TechnicalState technicalState;

	public Long getSerialNumbet() {
		return serialNumbet;
	}

	public void setSerialNumbet(Long serialNumbet) {
		this.serialNumbet = serialNumbet;
	}

	public Date getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(Date receiptDate) {
		this.receiptDate = receiptDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(Date productionYear) {
		this.productionYear = productionYear;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public InstrumentModel getInstrumentModel() {
		return instrumentModel;
	}

	public void setInstrumentModel(InstrumentModel instrumentModel) {
		this.instrumentModel = instrumentModel;
	}

	public Calibration getCalibration() {
		return calibration;
	}

	public void setCalibration(Calibration calibration) {
		this.calibration = calibration;
	}

	public Verification getVerification() {
		return verification;
	}

	public void setVerification(Verification verification) {
		this.verification = verification;
	}

	public TechnicalState getTechnicalState() {
		return technicalState;
	}

	public void setTechnicalState(TechnicalState technicalState) {
		this.technicalState = technicalState;
	}

}
