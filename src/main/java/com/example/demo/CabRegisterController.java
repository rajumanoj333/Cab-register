package com.example.demo;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CabRegisterController {

    @Autowired
    private CabService service;

    Logger log = Logger.getAnonymousLogger();

    @ResponseBody
    @RequestMapping("/register/{fullName}/{password}/{email}/{phoneNumber}")
    public String registerUser(
            @PathVariable("fullName") String fullName,
            @PathVariable("password") String password,
            @PathVariable("email") String email,
            @PathVariable("phoneNumber") String phoneNumber) {

        Cab cab = new Cab();
        cab.setFullName(fullName);
        cab.setPassword(password);
        cab.setEmail(email);
        cab.setPhoneNumber(phoneNumber);

        service.registerUser(cab);

        log.info("Cab registration successful for: " + fullName);
        return "Registration successful for " + fullName;
    }
}