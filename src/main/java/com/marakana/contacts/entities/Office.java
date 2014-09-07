package com.marakana.contacts.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Office extends BaseEntity {
	@Column
	private String name;

	@OneToOne
	private Address adrress;
	@ManyToOne
	private Company company;

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Office() {
	}

	public Office(String name, Address address) {
		this.name = name;
		this.adrress = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAdrress() {
		return adrress;
	}

	public void setAdrress(Address adrress) {
		this.adrress = adrress;
	}

}
