package com.sda.hotelcleancode.controller;

import com.sda.hotelcleancode.entities.Customer;
import com.sda.hotelcleancode.entities.Reservation;
import com.sda.hotelcleancode.entities.RoomType;
import com.sda.hotelcleancode.services.CustomerService;
import com.sda.hotelcleancode.services.ReservationService;
import com.sda.hotelcleancode.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ReservationController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private HttpServletRequest request;


    // sisse tulevad kuup'evad, tagasta toad mis ei ole nendel kuup'evadel bronnitud
    @PostMapping("/room/checkdates")
    public ModelAndView checkAvailability() {

        String dateString1 = request.getParameter("checkinDate");
        String dateString2 = request.getParameter("checkoutDate");

        LocalDate checkIn = LocalDate.parse(dateString1);
        LocalDate checkOut = LocalDate.parse(dateString2);

        List<LocalDate> dates = new ArrayList<>();
        dates.add(checkIn);
        dates.add(checkOut);


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("dates", dates);

        boolean hasRooms = reservationService.isAvailableRoom(checkIn, checkOut);
        if (hasRooms) {
            List<RoomType> roomTypes = reservationService.getAvailableRoomTypes(checkIn, checkOut);
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
    public String insertCustomerAndReservation(Customer customer, Reservation reservation) {
        return "reservationSuccess";
    }

}
