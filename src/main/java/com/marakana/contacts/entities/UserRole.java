package com.marakana.contacts.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class UserRole extends BaseEntity{
	@ManyToOne
	private User user;
	@Column
	private String role;
}
