/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marakana.contacts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marakana.contacts.entities.Person;

public interface PersonRepository extends JpaRepository<Person,Long> {
	
}
