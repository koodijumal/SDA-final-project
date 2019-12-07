package com.sda.hotelcleancode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequestMapping("/")
public class IndexController {

    @GetMapping("/")
    public String getIndexPage() {
        return "checkDates";
    }

    @GetMapping("/admin")
    public String getCheckDatePage() {
        return "admin";
    }

}
