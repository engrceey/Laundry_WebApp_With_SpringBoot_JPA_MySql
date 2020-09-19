package com.laundry.washer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


//User entity class that maps to database
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "userbios")
public class Userbio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String fullName;

    private String preferredName;

    @Size(min = 11, max = 11)
    @Column(unique = true)
    private String phoneNumber;

    @Column(unique = true)
    private String email;
    private String password;
    private String role;

}
