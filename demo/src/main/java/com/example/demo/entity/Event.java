package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="events")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private LocalDate date;

    private Integer duration;

    private String location;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(
            name="event_guest",
            joinColumns=@JoinColumn(name="event_id"),
            inverseJoinColumns =@JoinColumn(name="guest_id")
    )
    //@JsonIgnore
    private Set<Guest> guests=new HashSet<>();

    public Event() {}

    public Event(String title, LocalDate date, Integer duration, String location, Set<Guest> guests) {
        this.title = title;
        this.date = date;
        this.duration = duration;
        this.location = location;
        this.guests = guests;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setGuests(Set<Guest> guests) {
        this.guests = guests;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    public Integer getDuration() {
        return duration;
    }

    public String getLocation() {
        return location;
    }

    public Set<Guest> getGuests() {
        return guests;
    }
}
