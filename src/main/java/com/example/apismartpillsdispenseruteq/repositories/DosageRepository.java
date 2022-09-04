package com.example.apismartpillsdispenseruteq.repositories;

import com.example.apismartpillsdispenseruteq.entity.Dosage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DosageRepository extends JpaRepository<Dosage, Integer> {
    List<Dosage> findByMedicalTreatment_Id(int id);
}
