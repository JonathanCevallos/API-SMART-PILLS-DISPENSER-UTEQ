package com.example.apismartpillsdispenseruteq.repositories;

import com.example.apismartpillsdispenseruteq.entity.Dosage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DosageRepository extends JpaRepository<Dosage, Integer> {
    List<Dosage> findByMedicalTreatment_Id(int id);
   // Dosage findDosageByDate_dosageAndStateIsTrue(String filro) ;


    Optional<Dosage>  findDosageByDateTake(String filtro);

    // public List<Dosage> findByDate_dosage(String filtro);


    //Dosage findDosageByDate_dosage(String  filtro);

}
