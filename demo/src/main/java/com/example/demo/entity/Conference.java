package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="conferences")
public class Conference extends Event {


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="conference_speaker",
            joinColumns=@JoinColumn(name="conference_id"),
            inverseJoinColumns=@JoinColumn(name="speaker_id")
    )
    private Set<Speaker> speakers=new HashSet<>();


    public Conference() {}
    public Conference(String title, LocalDate date, Integer duration, String location, Set<Guest> guests, Set<Speaker> speakers) {
        super(title, date, duration, location, guests);
        this.speakers = speakers;
    }

    public void setSpeakers(Set<Speaker> speakers) {
        this.speakers = speakers;
    }

    public Set<Speaker> getSpeakers() {
        return speakers;
    }
}
