package com.sda.hotelcleancode.services;

import com.sda.hotelcleancode.entities.Room;
import com.sda.hotelcleancode.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public Room addNewRoom(Room room){
        return roomRepository.save(room);
    }



}
