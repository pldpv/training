/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.marakana.contacts.entities;

/**
 *
 * @author �����
 */
public class Contact {
    
    public Contact(){}
    public Contact(String name, Long addressId) {
        this.name = name;
        this.addressId = addressId;
    }
    private Long id;
    private String name;
    private Long addressId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }
}
