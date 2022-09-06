package com.example.apismartpillsdispenseruteq.repositories;

import com.example.apismartpillsdispenseruteq.entity.Carer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarerRepository extends JpaRepository<Carer, Integer> {
    public Carer findCarerByEmail(String email);

   // public Boolean existsCarerByEmailAndEmailEqualsAndVerification_codeEquals (String email);
}
