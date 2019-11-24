package com.sda.hotelcleancode.controller;

import com.sda.hotelcleancode.entities.Room;
import com.sda.hotelcleancode.entities.RoomBedType;
import com.sda.hotelcleancode.entities.RoomType;
import com.sda.hotelcleancode.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;

@Controller
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/room/add")
    public String addRoom() {

        //Hard coded - creates 5 rooms in database, if to run localhost http://localhost:8080/room/add in browser
        Room room = new Room(RoomType.STANDARD, 2, RoomBedType.TWIN, BigDecimal.valueOf(100.0));
        roomService.addNewRoom(room);
        Room room2 = new Room(RoomType.STANDARD, 2, RoomBedType.TWIN, BigDecimal.valueOf(100.0));
        roomService.addNewRoom(room2);
        Room room3 = new Room(RoomType.STANDARD, 2, RoomBedType.FULL, BigDecimal.valueOf(100.0));
        roomService.addNewRoom(room3);
        Room room4 = new Room(RoomType.DELUXE, 2, RoomBedType.TWIN, BigDecimal.valueOf(150.0));
        roomService.addNewRoom(room4);
        Room room5 = new Room(RoomType.DELUXE, 2, RoomBedType.FULL, BigDecimal.valueOf(150.0));
        roomService.addNewRoom(room5);
        return "";

        //TODO: html page will have form with login for hotel administrator for inserting new rooms (in future)
    }


}
