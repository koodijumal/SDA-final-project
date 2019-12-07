package com.sda.hotelcleancode.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min=1, max=30, message = "Max 30 characters")
    private String firstName;

    @NotNull
    @Size(min=1, max=30, message = "Max 30 characters")
    private String lastName;

    private String companyName;

    @NotNull
    @Column(unique = true)
    @Size(min=11, max=50, message = "Must be between 11 to 50 numbers")
    private String registryCode;

}
