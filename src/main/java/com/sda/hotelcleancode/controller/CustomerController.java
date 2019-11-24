package com.sda.hotelcleancode.controller;

import com.sda.hotelcleancode.entities.Customer;
import com.sda.hotelcleancode.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer/add")
    public String addCustomer() {
        Customer customer =
                new Customer("Liene", "Priede", "49502220356", "SDA");
        customerService.addCustomerToDatabase(customer);
        Customer customer1 =
                new Customer("Joonas", "Tamm", "39801110316", "Rudus");
        customerService.addCustomerToDatabase(customer1);
        Customer customer2 =
                new Customer("Tiit", "Hepa", "35601222356", "WHO");
        customerService.addCustomerToDatabase(customer2);
        Customer customer3 =
                new Customer("Tom", "Tommy", "39532220312", "Telia");
        customerService.addCustomerToDatabase(customer3);
        Customer customer4 =
                new Customer("Tiina", "Kask", "47600620156", "Tele2");
        customerService.addCustomerToDatabase(customer4);
        return "";
    }
}
