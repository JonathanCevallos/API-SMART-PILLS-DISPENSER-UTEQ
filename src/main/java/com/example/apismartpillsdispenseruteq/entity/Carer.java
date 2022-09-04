package com.example.apismartpillsdispenseruteq.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "carer")
public class Carer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "state")
    private Boolean state = true;

    @Column(name = "registration_date")
    private LocalDateTime registration_date;

    @Column(name = "name", length = 70)
    private String name;

    @Column(name = "phone_number", length = 15)
    private String phone_number;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name="verification_code",length = 8, updatable = false)
    private String verification_code;

    @Column(name = "url_image")
    private String url_image;

    @PrePersist
    public void PrePersist() {
        registration_date = LocalDateTime.now();
    }
}
