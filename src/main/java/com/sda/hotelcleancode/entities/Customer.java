package com.sda.hotelcleancode.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@ToString
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

    public Customer(@NotBlank String firstname, @NotBlank String lastname, @NotBlank String registrycode) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.lastName = registrycode;
    }

    public Customer(@NotBlank String firstname, @NotBlank String lastname,
                    @NotBlank String registrycode, String companyname) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.lastName = registrycode;
        this.companyName = companyname;
    }

}
