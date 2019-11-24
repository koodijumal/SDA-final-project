package com.sda.hotelcleancode.services;

import com.sda.hotelcleancode.entities.Customer;
import com.sda.hotelcleancode.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer addCustomerToDatabase(Customer customer){
        return customerRepository.save(customer);
    }
}
