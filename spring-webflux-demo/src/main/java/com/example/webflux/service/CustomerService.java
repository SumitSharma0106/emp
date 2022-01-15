package com.example.webflux.service;

import com.example.webflux.dao.CustomerDao;
import com.example.webflux.dto.Customers;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerDao customerDao;

    public List<Customers> getCustomers(){
        long start=System.currentTimeMillis();
        List<Customers> customers = customerDao.getCustomers();
        long end=System.currentTimeMillis();
        System.out.println(end-start);
        return customers;
    }

    public Flux<Customers> getCustomersStream(){
        long start=System.currentTimeMillis();
        Flux<Customers> customers = customerDao.getCustomersStream();
        long end=System.currentTimeMillis();
        System.out.println(end-start);
        return customers;
    }
}
