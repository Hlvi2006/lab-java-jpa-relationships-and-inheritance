package com.example.demo.controller;

import com.example.demo.entity.Association;
import com.example.demo.repository.AssociationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/associations")
public class AssociationController {
    private AssociationRepository associationRepo;

    public AssociationController(AssociationRepository associationRepo) {
        this.associationRepo = associationRepo;
    }

    @PostMapping
    public Association create(@RequestBody Association association){
        return associationRepo.save(association);
    }

    @GetMapping
    public List<Association> findAll(){
        return associationRepo.findAll();
    }

    @DeleteMapping
    public void deleteAll(){
        associationRepo.deleteAll();
    }
}
