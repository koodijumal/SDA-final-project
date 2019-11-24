package com.sda.hotelcleancode.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
public class Reservation {

    public Reservation(@NotNull Integer room, @NotNull Integer customer, @NotNull LocalDate checkindate,
                       @NotNull LocalDate checkoutdate,
                       @NotNull PaymentType payment, @NotNull ReservationStatus status) {
        this.room = room;
        this.customer = customer;
        this.checkinDate = checkindate;
        this.checkoutDate = checkoutdate;
        this.payment = payment;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private Integer room;

    @NotNull
    private Integer customer;

    @NotNull
    private LocalDate checkinDate;

    @NotNull
    private LocalDate checkoutDate;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private PaymentType payment;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private ReservationStatus status;
// nice one







}
