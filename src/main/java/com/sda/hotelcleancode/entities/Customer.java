package com.sda.hotelcleancode.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String firstName;

    private String lastName;

    private String companyName;

    @Column(unique = true)
    private String registryCode;

    public Customer(String firstname, String lastname, String registrycode) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.lastName = registrycode;
    }

    public Customer(String companyname, String registrycode) {
        this.companyName = companyname;
        this.registryCode = registrycode;
    }

}
