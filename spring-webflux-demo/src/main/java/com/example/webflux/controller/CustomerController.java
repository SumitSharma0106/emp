package com.example.webflux.controller;

import com.example.webflux.dto.Customers;
import com.example.webflux.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/services")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public List<Customers> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping(value = "/stream",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customers> getCustomersStream(){
        return customerService.getCustomersStream();
    }
}
