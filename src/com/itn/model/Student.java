/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.model;

import java.io.Serializable;

/**
 *
 * @author sumit
 */
public class Student implements Serializable{
    private static final Serializable sir=234566L;
    private int id;
    private String name;
    private String address;
    private int roll;

    public Student() {
    }

    public Student(int id, String name, String address, int roll) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.roll = roll;
    }

    public Student(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", address=" + address + ", roll=" + roll + '}';
    }
    
    
   
}
