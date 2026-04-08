package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="guests")
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private GuestStatus status;

    @ManyToMany(mappedBy = "guests")
    @JsonIgnore
    private Set<Event> events=new HashSet<>();

    public Guest() {}

    public Guest(String name, GuestStatus status, Set<Event> event) {
        this.name = name;
        this.status = status;
        this.events = event;
    }

    public Set<Event> getEvent() {
        return events;
    }

    public Long getId() {
        return id;
    }

    public GuestStatus getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public void setEvent(Set<Event> event) {
        this.events = event;
    }

    public void setStatus(GuestStatus status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }
}
