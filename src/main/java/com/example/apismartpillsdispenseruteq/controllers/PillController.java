package com.example.apismartpillsdispenseruteq.controllers;

import com.example.apismartpillsdispenseruteq.entity.Pill;
import com.example.apismartpillsdispenseruteq.services.PillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pill")
@CrossOrigin("*")
public class PillController {

    @Autowired
    private PillService pillService;

    //LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Pill>> getAll()
    {
        try
        {
            return ResponseEntity.ok().body(pillService.findAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Pill> finfById(@PathVariable("id")int id)
    {
        try
        {
            return ResponseEntity.ok().body(pillService.findById(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Pill> create (@RequestBody Pill entity)
    {
        try
        {
            return ResponseEntity.ok().body(pillService.save(entity));
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
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(pillService.delete(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<Pill>update(@PathVariable int id, @RequestBody Pill entity)
    {
        try
        {
            return ResponseEntity.ok().body(pillService.update(id,entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }
}
