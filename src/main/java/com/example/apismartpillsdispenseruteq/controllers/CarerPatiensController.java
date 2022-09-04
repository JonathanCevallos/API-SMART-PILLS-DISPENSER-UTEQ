package com.example.apismartpillsdispenseruteq.controllers;

import com.example.apismartpillsdispenseruteq.entity.Patient;
import com.example.apismartpillsdispenseruteq.repositories.PatientRepositirory;
import com.example.apismartpillsdispenseruteq.services.CarerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("api/carer/patients")
@CrossOrigin("*")
public class CarerPatiensController {
    @Autowired
    private CarerService carerService;
    @Autowired
    private PatientRepositirory patientRepositirory;

    //LISTAR TODOS LOS PATIENTS DE UN CARER
    @RequestMapping(value = "{id}")
    public ResponseEntity<List<Patient>> finfById(@PathVariable("id")int id)
    {
        try
        {
            return ResponseEntity.ok().body(patientRepositirory.findByCarer_Id(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }


}
