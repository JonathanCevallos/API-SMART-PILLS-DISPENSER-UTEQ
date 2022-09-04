package com.example.apismartpillsdispenseruteq.controllers;

import com.example.apismartpillsdispenseruteq.entity.Carer;
import com.example.apismartpillsdispenseruteq.repositories.CarerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/carer/email")
@CrossOrigin("*")
public class CarerFindByEmailController {
    @Autowired
    private CarerRepository carerRepository;

    //BUSCAR POR EMAIL
    @RequestMapping(value = "{email}")
    public ResponseEntity<Carer> finfById(@PathVariable("email")String email)
    {
        try
        {
            return ResponseEntity.ok().body(carerRepository.findCarerByEmail(email));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }
}
