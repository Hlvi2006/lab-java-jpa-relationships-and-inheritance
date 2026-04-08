package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="divisions")
public class Division {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String district;

    private String president;

    @ManyToOne
    @JoinColumn(name="association_id")
    private Association association;

    @OneToMany(mappedBy = "division",
            cascade=CascadeType.ALL,
            fetch=FetchType.LAZY)
    @JsonIgnore
    private List<Member> members;

    public Division() {}

    public Division( String name, String district, String president, List<Member> members) {

        this.name = name;
        this.district = district;
        this.president = president;
        this.members = members != null ? members : new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDistrict() {
        return district;
    }

    public String getPresident() {
        return president;
    }

    public List<Member> getMembers() {
        return members;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
