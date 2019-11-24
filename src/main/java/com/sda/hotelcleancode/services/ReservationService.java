package com.sda.hotelcleancode.services;

import com.sda.hotelcleancode.entities.Reservation;
import com.sda.hotelcleancode.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation addReservation(Reservation customer){
        return reservationRepository.save(customer);
    }

}
