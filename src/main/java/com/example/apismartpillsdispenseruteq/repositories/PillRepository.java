package com.example.apismartpillsdispenseruteq.repositories;

import com.example.apismartpillsdispenseruteq.entity.Pill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PillRepository extends JpaRepository<Pill, Integer> {
}
