package com.sda.hotelcleancode.controller;

import com.sda.hotelcleancode.entities.Customer;
import com.sda.hotelcleancode.entities.Reservation;
import com.sda.hotelcleancode.services.CustomerService;
import com.sda.hotelcleancode.services.ReservationService;
import com.sda.hotelcleancode.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class ReservationController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ReservationService reservationService;

    // sisse tulevad kuup'evad, tagasta toad mis ei ole nendel kuup'evadel bronnitud
    @PostMapping("/room/checkdates")
    public String checkAvailability() {
        LocalDate checkIn = LocalDate.of(2019, 11, 24);
        LocalDate checkOut = LocalDate.of(2019, 11, 25);
        //TODO: figure out how to get real dates from HTML pages, we don't have now model for this?
        boolean answer = reservationService.isAvailableRoom(checkIn, checkOut);
        if (answer) {
            return "checkDatesSuccess";
            //TODO: return and show already chosen dates for finishing the booking
            //TODO: return and show which types of rooms are available, and let choose only one of available room types
            //TODO: create a form for inserting a customer data
            //TODO: if dates (not any more changeable) are chosen, insert a new Customer and also a new Reservation to database

        }
        return "checkDatesFail";
    }

    @GetMapping("/room/checkdates")
    public String getCheckDatePage() {
        return "checkDates";
    }

    @PostMapping("room/reservation")
    public String insertCustomerAndReservation(Customer customer, Reservation reservation){
        return "reservationSuccess";
    }

}
