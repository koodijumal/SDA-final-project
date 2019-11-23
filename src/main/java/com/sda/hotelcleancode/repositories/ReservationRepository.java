package com.sda.hotelcleancode.repositories;

import com.sda.hotelcleancode.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
