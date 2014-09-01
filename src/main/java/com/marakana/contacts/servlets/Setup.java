/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.marakana.contacts.servlets;



import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.marakana.contacts.entities.Address;
import com.marakana.contacts.entities.Contact;

import com.marakana.contacts.repositories.AddressRepository;
import com.marakana.contacts.repositories.ContactsRepository;

/**
 *
 * @author ֵגדום
 */
@WebListener
public class Setup implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
        try {
        	new AddressRepository().init();
        	new AddressRepository().create(new Address("Sumskaya","Los Angeles","LA","dsfdf"));
        	ContactsRepository contactRepository= new ContactsRepository();
        	contactRepository.init();
        	contactRepository.create(new Contact("Evgen",0L));
        	contactRepository.create(new Contact("Dan",0L));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {}
    
}
