package com.sda.hotelcleancode.controller;

import com.sda.hotelcleancode.services.CustomerService;
import com.sda.hotelcleancode.services.ReservationService;
import com.sda.hotelcleancode.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReservationController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ReservationService reservationService;

    // sisse tulevad kuup'evad, tagasta toad mis ei ole nendel kuup'evadel bronnitud
    @GetMapping("/room/checkdates")
    public String getCheckDatePage() {
        return "checkDates";
    }

}
