package com.laundry.washer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


//Post entity class that maps to database
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PostRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;
    private String phoneNumber;
    private String message;
    private String service;

    private String status = "PENDING";
    private String date;

}
