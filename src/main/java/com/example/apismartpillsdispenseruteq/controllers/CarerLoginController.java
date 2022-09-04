package com.example.apismartpillsdispenseruteq.controllers;

import com.example.apismartpillsdispenseruteq.entity.Carer;
import com.example.apismartpillsdispenseruteq.repositories.CarerRepository;
import com.example.apismartpillsdispenseruteq.services.CarerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/carer/login")
@CrossOrigin("*")
public class CarerLoginController {

    @Autowired
    private CarerRepository carerRepository;



}
