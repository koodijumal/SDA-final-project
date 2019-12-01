package com.sda.hotelcleancode.repositories;

import com.sda.hotelcleancode.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {
}
