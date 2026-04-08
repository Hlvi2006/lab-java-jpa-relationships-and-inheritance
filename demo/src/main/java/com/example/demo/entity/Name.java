package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;


@Embeddable
public class Name {
    private String salutation;

    @Column(name="first_name", nullable=false)
    private String firstName;

    @Column(name="middle_name",nullable=false)
    private String middleName;

    @Column(name="last_name",nullable=false)
    private String lastName;

    public String getSalutation() {
        return salutation;
    }

    public Name(){}

    public Name(String salutation, String firstName, String middleName, String lastName) {
        this.salutation = salutation;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
