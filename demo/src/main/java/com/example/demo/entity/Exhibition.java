package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="exhibitions")
public class Exhibition extends Event{
    public Exhibition() {}
}
