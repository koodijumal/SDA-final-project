package com.sda.hotelcleancode.controller;

import com.sda.hotelcleancode.entities.Customer;
import com.sda.hotelcleancode.entities.Reservation;
import com.sda.hotelcleancode.entities.RoomType;
import com.sda.hotelcleancode.services.ReservationService;
import com.sda.hotelcleancode.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

@Controller
public class ReservationController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private HttpServletRequest request;


    // sisse tulevad kuup'evad, tagasta toad mis ei ole nendel kuup'evadel bronnitud
    @PostMapping("/room/checkdates")
    public ModelAndView checkAvailability(@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate checkinDate, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate checkoutDate) {


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("checkinDate", checkinDate);
        modelAndView.addObject("checkoutDate", checkoutDate);

        boolean hasRooms = reservationService.isAvailableRoom(checkinDate, checkoutDate);
        if (hasRooms) {
            List<RoomType> roomTypes = reservationService.getAvailableRoomTypes(checkinDate, checkoutDate);
            modelAndView.addObject("roomTypes", roomTypes);
            modelAndView.setViewName("checkDatesSuccess");
        } else {
            modelAndView.setViewName("checkDatesFail");
        }
        return modelAndView;
    }
    //TODO: return and show already chosen dates for finishing the booking
    //TODO: return and show which types of rooms are available, and let choose only one of available room types
    //TODO: if dates (not any more changeable) are chosen, insert a new Customer and also a new Reservation to database

    @GetMapping("/room/checkdates")
    public String getCheckDatePage() {
        return "checkDates";
    }

    @PostMapping("reservation/add")
    public String insertCustomerAndReservation(Customer customer, Reservation reservation, RoomType roomType) {
        reservationService.addReservation(reservation, customer, roomType);
        return "reservationSuccess";
    }

}
