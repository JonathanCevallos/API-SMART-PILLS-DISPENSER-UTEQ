package com.example.apismartpillsdispenseruteq.controllers;

import com.example.apismartpillsdispenseruteq.services.MedicalTreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/medical-treatment/max-id")
@CrossOrigin("*")
public class MedicalTreatmentMaxIdController {

    @Autowired
    private MedicalTreatmentService medicalTreatmentService;

    //LISTAR TODO
    @GetMapping
    private int maxId (){
        return medicalTreatmentService.maxId();
    }
   }
