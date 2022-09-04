package com.example.apismartpillsdispenseruteq.controllers;

import com.example.apismartpillsdispenseruteq.entity.Dosage;
import com.example.apismartpillsdispenseruteq.repositories.DosageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/medical-treatment/dosages")
@CrossOrigin("*")
public class MedicalTreatmentDosagesController {
    @Autowired
    DosageRepository dosageRepository;
    @RequestMapping(value = "{id}")
    public ResponseEntity<List<Dosage>> finfById(@PathVariable("id")int id)
    {
        try
        {
            return ResponseEntity.ok().body(dosageRepository.findByMedicalTreatment_Id(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }
}
