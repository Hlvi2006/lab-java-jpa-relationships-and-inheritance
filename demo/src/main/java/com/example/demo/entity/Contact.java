package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String company;

    @Column(nullable=false)
    private String title;

    @Embedded
    private Name name;

    public Contact(){}

    public Contact(Long id, String company, String title, Name name) {
        this.id = id;
        this.company = company;
        this.title = title;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getCompany() {
        return company;
    }

    public String getTitle() {
        return title;
    }

    public Name getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setName(Name name) {
        this.name = name;
    }
}
