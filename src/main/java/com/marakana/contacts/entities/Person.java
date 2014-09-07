package com.marakana.contacts.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Person extends Contact {
	public Person() {
	}

	public Person(String name, Address address) {
		super(name);
		this.address = address;
	}

	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String getUrl() {
		return "person?id=" + getId();
	}
}
