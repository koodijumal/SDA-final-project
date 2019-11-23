package com.sda.hotelcleancode.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
public class Reservation {

    public Reservation(@NotBlank Integer room, @NotBlank Integer customer, @NotBlank LocalDate checkindate, @NotBlank LocalDate checkoutdate, @NotBlank String payment, @NotBlank String status) {
        this.room = room;
        this.customer = customer;
        this.checkindate = checkindate;
        this.checkoutdate = checkoutdate;
        this.payment = payment;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    private Integer room;

    @NotBlank
    private Integer customer;

    @NotBlank
    private LocalDate checkindate;

    @NotBlank
    private LocalDate checkoutdate;

    @NotBlank
    private String payment;

    @NotBlank
    private String status;
// nice one







}
