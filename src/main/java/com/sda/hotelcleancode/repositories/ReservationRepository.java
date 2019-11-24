package com.sda.hotelcleancode.repositories;

import com.sda.hotelcleancode.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {


}
