/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marakana.contacts.repositories;

import com.marakana.contacts.entities.Contact;

public class ContactsRepository extends Repository<Contact> {
	public ContactsRepository() {
		super(Contact.class);
	}
}
