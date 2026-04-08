package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="associations")
public class Association {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Double id;

    @Column(nullable=false)
    private String name;

    @OneToMany(mappedBy = "association",
            cascade=CascadeType.ALL,
            fetch=FetchType.LAZY)
    @JsonIgnore
    private List<Division> divisions=new ArrayList<>();

    public Association() {}

    public Association( String name, List<Division> divisions) {

        this.name = name;
        this.divisions = divisions != null ? divisions : new ArrayList<>();
    }

    public Double getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Division> getDivisions() {
        return divisions;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setDivisions(List<Division> divisions) {
        this.divisions = divisions;
    }
}
