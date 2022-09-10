package com.example.apismartpillsdispenseruteq.controllers;

import com.example.apismartpillsdispenseruteq.entity.Carer;
import com.example.apismartpillsdispenseruteq.entity.Dosage;
import com.example.apismartpillsdispenseruteq.repositories.DosageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.Optional;

@RestController
@RequestMapping("api/dosage/take")
@CrossOrigin("*")
public class DosageTakeController {

    @Autowired
    private DosageRepository dosageRepository;

    //BUSCAR POR DATE
    @RequestMapping(value = "{filtro}")
    public ResponseEntity<Optional<Dosage>> finfByDateDosage(@PathVariable("filtro")String filtro)
    {
        try
        {
            return ResponseEntity.ok().body(dosageRepository.findDosageByDateTake(filtro));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }



}
