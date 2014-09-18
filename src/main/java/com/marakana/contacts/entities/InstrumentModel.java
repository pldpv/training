package com.marakana.contacts.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class InstrumentModel extends BaseEntity {
	public InstrumentModel() {
	}

	public InstrumentModel(String model, InstrumentType instrumentType,
			Set<Instrument> instrument) {
		super();
		this.model = model;
		this.instrumentType = instrumentType;
		this.instrument = instrument;
	}

	@Column
	private String model;

	@ManyToOne
	private InstrumentType instrumentType;

	@OneToMany(mappedBy = "instrumentModel")
	private Set<Instrument> instrument;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public InstrumentType getInstrumentType() {
		return instrumentType;
	}

	public void setInstrumentType(InstrumentType instrumentType) {
		this.instrumentType = instrumentType;
	}

	public Set<Instrument> getInstrument() {
		return instrument;
	}

	public void setInstrument(Set<Instrument> instrument) {
		this.instrument = instrument;
	}

}
