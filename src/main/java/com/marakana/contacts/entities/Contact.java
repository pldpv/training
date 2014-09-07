/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.marakana.contacts.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author ֵגדום
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Contact extends BaseEntity{
    
    public Contact(){}

    public Contact(String name) {
        this.name = name;
    }
    
    
    @Column
    private String name;
    
     public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public abstract String getUrl();
    
   
}
