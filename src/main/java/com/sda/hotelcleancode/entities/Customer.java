package com.sda.hotelcleancode.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private String companyName;

    @NotNull
    @Column(unique = true)
    private String registryCode;

    public Customer(@NotNull String firstname, @NotNull String lastname, @NotNull String registrycode) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.registryCode = registrycode;
    }

    public Customer(@NotNull String firstname, @NotNull String lastname,
                    @NotNull String registrycode, String companyname) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.registryCode = registrycode;
        this.companyName = companyname;
    }

}
