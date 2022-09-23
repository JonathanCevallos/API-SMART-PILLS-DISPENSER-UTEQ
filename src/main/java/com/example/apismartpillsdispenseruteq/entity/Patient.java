package com.example.apismartpillsdispenseruteq.entity;

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
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @Column(name = "state")
    private Boolean state = true;

    @Column(name = "name", length = 70)
    private String name;

    @Column(name = "gender", length = 10)
    private String gender;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "url_image")
    private String urlImage;

    @ManyToOne
    @JoinColumn(name = "id_carer")
    Carer carer;

    @PrePersist
    public void PrePersist() {
        registrationDate = LocalDateTime.now();
    }

}
