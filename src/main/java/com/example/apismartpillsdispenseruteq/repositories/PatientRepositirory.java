package com.example.apismartpillsdispenseruteq.repositories;

import com.example.apismartpillsdispenseruteq.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepositirory extends JpaRepository<Patient, Integer> {

    //Metodo para listar los pacientes que tiene un cuidador
    List<Patient> findByCarer_Id(int id);
}
