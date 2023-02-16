package com.exchange.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone")
    private String phoneNumber;

    private String email;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "status")
    boolean isActive;
}
