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
        Room room = new Room(RoomType.STANDARD, 2, RoomBedType.TWIN, BigDecimal.valueOf(100.0));
        roomService.addNewRoom(room);
        return "";
    }


}
