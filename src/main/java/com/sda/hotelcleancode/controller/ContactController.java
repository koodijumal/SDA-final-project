package com.sda.hotelcleancode.controller;

import com.sda.hotelcleancode.entities.Message;
import com.sda.hotelcleancode.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/contact")
    public String getContactPage() {
        return "contact";
    }

    @PostMapping("/contact/send")
    public String saveMessage(Message message) {
        // TODO: save to database and return a message to the user.
        System.out.println(message);
        messageService.addNewMessage(message);
        return "contact";
    }
}
