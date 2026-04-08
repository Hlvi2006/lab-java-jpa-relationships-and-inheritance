package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    @ManyToOne
    @JoinColumn(name="division_id")
    private Division division;

    private LocalDate renewalDate;

    public Member() {}

    public Member( String name, MemberStatus status, LocalDate renewalDate) {
        this.name = name;
        this.status = status;
        this.renewalDate = renewalDate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public MemberStatus getStatus() {
        return status;
    }

    public LocalDate getRenewalDate() {
        return renewalDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(MemberStatus status) {
        this.status = status;
    }

    public void setRenewalDate(LocalDate renewalDate) {
        this.renewalDate = renewalDate;
    }
}
