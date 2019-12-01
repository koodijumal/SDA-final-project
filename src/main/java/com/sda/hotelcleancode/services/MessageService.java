package com.sda.hotelcleancode.services;

import com.sda.hotelcleancode.entities.Message;
import com.sda.hotelcleancode.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public Message addNewMessage(Message message){
        return messageRepository.save(message);
    }

}
