package com.example.webflux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class WebFluxTest {

    @Test
    public void testMono(){
        Mono<String> monoString = Mono.just("java").log();
        monoString.subscribe(System.out::println);
    }

    @Test
    public void testMonoError(){
        Mono<Object> monoError = Mono.just("Test").
                then(Mono.error(new RuntimeException("Exception Occured")))
                .log();
        monoError.subscribe(System.out::println,(e)->System.out.println(e.getMessage()));

    }

    @Test
    public void testFlux(){
        Flux<String> fluxTest = Flux.just("Spring", "Boot").log();
        fluxTest.subscribe(System.out::println);
    }

    @Test
    public void testFluxError(){
        Flux<?> fluxError = Flux.just("Spring")
                .concatWith(Flux.error(new RuntimeException("Exception Occured")))
                .log();
        fluxError.subscribe(System.out::println,(e)->System.out.println(e.getMessage()));
    }
}
