package com.example.apismartpillsdispenseruteq.controllers;

import com.example.apismartpillsdispenseruteq.entity.MedicalTreatment;
import com.example.apismartpillsdispenseruteq.services.MedicalTreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/medical-treatment")
@CrossOrigin("*")
public class MedicalTreatmentController {

    @Autowired
    private MedicalTreatmentService medicalTreatmentService;

    //LISTAR TODO
    @GetMapping
    public ResponseEntity<List<MedicalTreatment>> getAll()
    {
        try
        {
            return ResponseEntity.ok().body(medicalTreatmentService.findAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<MedicalTreatment> finfById(@PathVariable("id")int id)
    {
        try
        {
            return ResponseEntity.ok().body(medicalTreatmentService.findById(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<MedicalTreatment> create (@RequestBody MedicalTreatment entity)
    {
        try
        {
            return ResponseEntity.ok().body(medicalTreatmentService.save(entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ELIMINAR
    @DeleteMapping(value =  "{id}")
    public ResponseEntity<Boolean> delete (@PathVariable int id)
    {
        try
        {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(medicalTreatmentService.delete(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<MedicalTreatment>update(@PathVariable int id, @RequestBody MedicalTreatment entity)
    {
        try
        {
            return ResponseEntity.ok().body(medicalTreatmentService.update(id,entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }
}
