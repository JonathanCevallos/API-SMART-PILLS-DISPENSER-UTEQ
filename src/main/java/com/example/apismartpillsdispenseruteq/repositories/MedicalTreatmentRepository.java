package com.example.apismartpillsdispenseruteq.repositories;

import com.example.apismartpillsdispenseruteq.entity.MedicalTreatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalTreatmentRepository extends JpaRepository<MedicalTreatment, Integer> {
 List<MedicalTreatment>findByPatient_Id(int id);
}
