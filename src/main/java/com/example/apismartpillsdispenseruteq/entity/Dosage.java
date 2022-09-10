package com.example.apismartpillsdispenseruteq.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dosage")
public class Dosage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "date_hour")
    private Date dateHour;


    @Column(name = "state")
    private Boolean state=true;

    @Column(name ="prescription", length = 200)
    private String prescription;

    @Column(name ="date_take", length = 16)
    private String dateTake;

    @ManyToOne
    @JoinColumn(name = "id_pill")
    Pill pill;

    @ManyToOne
    @JoinColumn(name = "id_medical_treatment")
    MedicalTreatment medicalTreatment;

    @PrePersist
    public void PrePersist() {
        registrationDate = LocalDateTime.now();
    }

}

