package com.example.webflux.dao;

import com.example.webflux.dto.Customers;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDao {

    public static void sleepTime(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Customers> getCustomers(){
        return IntStream.rangeClosed(1,100000)
                .peek(i->System.out.println("Processing count : " + i) )
                .mapToObj(i->(new Customers(i,"customer" + i)))
                .collect(Collectors.toList());
    }

    public Flux<Customers> getCustomersStream(){
        return Flux.range(1,100000)
                .doOnNext(i->System.out.println("Processing count : " + i) )
                .map(i-> new Customers(i,"Customer " + i));
    }

    public Flux<Customers> getCustomer(){
        return Flux.range(1,100000)
                .doOnNext(i->System.out.println("Processing count : " + i))
                .map((i-> new Customers(i,"Customer " + i)));
    }
}
