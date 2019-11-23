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

    private String firstname;

    private String lastname;

    private String companyname;

    @Column(unique = true)
    private String registrycode;

    public Customer(String firstname, String lastname, String registrycode) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.lastname = registrycode;
    }

    public Customer(String companyname, String registrycode) {
        this.companyname = companyname;
        this.registrycode = registrycode;
    }

}
