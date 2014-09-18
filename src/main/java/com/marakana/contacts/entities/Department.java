package com.marakana.contacts.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Department extends BaseEntity {
	private String name;
	private String director;
	@OneToMany(mappedBy = "department")
	private Set<Instrument> instruments;
	@ManyToOne
	private Company company;

	public Department() {
	}

	public Department(String name, String director,
			Set<Instrument> instruments, Company company) {
		this.name = name;
		this.director = director;
		this.instruments = instruments;
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public Set<Instrument> getInstruments() {
		return instruments;
	}

	public void setInstruments(Set<Instrument> instruments) {
		this.instruments = instruments;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
}
