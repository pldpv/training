package com.marakana.contacts.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Company extends UrlEntity {

	private String name;
	private String director;
	@OneToMany(mappedBy = "company",cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Department> departments;
	@OneToMany(mappedBy = "company")
	private Set<User> users;
	@ManyToOne(optional = false)
	private RailwayService railwayService;

	public Company() {
	}

	public Company(String name, String director, Set<Department> departments,
			Set<User> users, RailwayService railwayService) {
		this.name = name;
		this.director = director;
		this.departments = departments;
		this.users = users;
		this.railwayService = railwayService;
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

	public Set<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public RailwayService getRailwayService() {
		return railwayService;
	}

	public void setRailwayService(RailwayService railwayService) {
		this.railwayService = railwayService;
	}


}
