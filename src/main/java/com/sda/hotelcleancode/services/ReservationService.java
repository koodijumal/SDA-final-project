package com.sda.hotelcleancode.services;

import com.sda.hotelcleancode.entities.*;
import com.sda.hotelcleancode.repositories.CustomerRepository;
import com.sda.hotelcleancode.repositories.ReservationRepository;
import com.sda.hotelcleancode.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    public Reservation addReservation(Reservation reservation, Customer customer, RoomType roomType) {
        //Save customer
        //TODO check customer.registryCode and then don't add to customer datatable

        Customer existingCustomer = customerRepository.findCustomerByRegistryCode(customer.getRegistryCode());

        if (existingCustomer == null) {
           Customer c = customerRepository.save(customer);
            reservation.setCustomer(c.getId());
        } else {
            reservation.setCustomer(existingCustomer.getId());
        }
        reservation.setPayment(PaymentType.NOT_PAID);
        reservation.setStatus(ReservationStatus.ACTIVE);

        List<Room> availableRooms =
                getAvailableRoomsByDates(reservation.getCheckinDate(), reservation.getCheckoutDate());
        for (Room r : availableRooms) {
            if (r.getType() == roomType) {
                reservation.setRoom(r.getId());
                break;
            }
        }

        //save reservation
        return reservationRepository.save(reservation);
    }

    public List<RoomType> getAvailableRoomTypes(LocalDate checkIn, LocalDate checkOut) {
        List<Room> availableRooms = getAvailableRoomsByDates(checkIn, checkOut);
        List<RoomType> availableRoomTypes = new ArrayList<>();

        for (Room room : availableRooms) {
            if (!availableRoomTypes.contains(room.getType())) {
                availableRoomTypes.add(room.getType());
            }
        }

        return availableRoomTypes;
    }

    public boolean isAvailableRoom(LocalDate checkIn, LocalDate checkOut) {
        return !getAvailableRoomsByDates(checkIn, checkOut).isEmpty();
    }

//    public boolean isAvailableRoom(LocalDate checkIn, LocalDate checkOut) {
//        // Get all reservations from table
//        List<Reservation> allReservations = reservationRepository.findAll();
//
//        // Get ID-s of all the rooms has overlapping dates with given dates
//        List<Integer> bookedRoomIDs = getBookedRoomsIDs(allReservations, checkIn, checkOut);
//
//        // Get all rooms from rooms table
//        List<Room> allRooms = roomRepository.findAll();
//
//        // Return list of available rooms
//        return !getAvailableRoomsByBookedIDs(bookedRoomIDs, allRooms).isEmpty();
//    }

    private List<Room> getAvailableRoomsByDates(LocalDate checkIn, LocalDate checkOut) {
        // Get all reservations from table
        List<Reservation> allReservations = reservationRepository.findAll();

        // Get ID-s of all the rooms has overlapping dates with given dates
        List<Integer> bookedRoomIDs = getBookedRoomsIDs(allReservations, checkIn, checkOut);

        // Get all rooms from rooms table
        List<Room> allRooms = roomRepository.findAll();

        // Return list of available rooms
        return getAvailableRoomsByBookedIDs(bookedRoomIDs, allRooms);
    }

    private List<Room> getAvailableRoomsByBookedIDs(List<Integer> bookedRoomIDs, List<Room> allRooms) {
        List<Room> availableRooms = new ArrayList<>();

        // If room id is not in booked rooms id list then add it to the availableRooms list
        for (Room room : allRooms) {
            if (!bookedRoomIDs.contains(room.getId())) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    private List<Integer> getBookedRoomsIDs(List<Reservation> allReservations, LocalDate checkIn, LocalDate checkOut) {
        List<Integer> reservedIds = new ArrayList<>();

        // If reservation has overlapping date with given dates then add the room id to reservedIDs list.
        for (Reservation res : allReservations) {
            if ((res.getCheckinDate().compareTo(checkIn) >= 0 && res.getCheckinDate().compareTo(checkOut) <= 0)
                    || (res.getCheckoutDate().compareTo(checkIn) >= 0 && res.getCheckoutDate().compareTo(checkOut) <= 0)) {
                // if room id is not in list already then add it
                if (!reservedIds.contains(res.getRoom())) {
                    reservedIds.add(res.getRoom());
                }
            }
        }
        return reservedIds;
    }


}
