package com.sda.hotelcleancode.controller;

import com.sda.hotelcleancode.entities.Room;
import com.sda.hotelcleancode.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

//    kui lisad edukalt ruumi siis saadab add room lehele
    @GetMapping("/add")
    @Secured("ROLE_ROOM_WRITE")
    public String getAddRoomPage() {
        return "addRoom";
    }

//kui lisad ruumi siis saadab success lehele
    @PostMapping("/add")
    @Secured("ROLE_ROOM_WRITE")
    public String addRoom(Room room) {
        roomService.addNewRoom(room);
        return "roomAddedSuccess";

        //TODO: html page will have form with login for hotel administrator for inserting new rooms (in future)

    }

//    siin miskit vale, ilma selleta korras
    @GetMapping("/addsuccess")
    public String getAddRoomPageAgain() {
        return "addRoom";
    }

}
