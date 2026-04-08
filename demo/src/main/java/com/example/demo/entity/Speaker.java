package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="speakers")
public class Speaker {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer presentationDuration;

    @ManyToMany(mappedBy = "speakers")
    @JsonIgnore
    private Set<Conference> conferences=new HashSet<>();

    public Speaker() {}

    public Speaker(Set<Conference> conferences, Integer presentationDuration, String name) {
        this.conferences = conferences;
        this.presentationDuration = presentationDuration;
        this.name = name;
    }

    public void setConferences(Set<Conference> conferences) {
        this.conferences = conferences;
    }

    public Integer getPresentationDuration() {
        return presentationDuration;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public Set<Conference> getConferences() {
        return conferences;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPresentationDuration(Integer presentationDuration) {
        this.presentationDuration = presentationDuration;
    }
}
