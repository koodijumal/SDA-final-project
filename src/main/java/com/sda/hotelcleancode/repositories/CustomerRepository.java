package com.sda.hotelcleancode.repositories;

import com.sda.hotelcleancode.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findCustomerByRegistryCode(String code);
}
