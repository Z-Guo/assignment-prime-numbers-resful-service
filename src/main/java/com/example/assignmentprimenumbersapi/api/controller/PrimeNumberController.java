package com.example.assignmentprimenumbersapi.api.controller;

import com.example.assignmentprimenumbersapi.service.PrimeService;
import com.example.assignmentprimenumbersapi.api.model.PrimeNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class PrimeNumberController {

    private final PrimeService primeService;

    @Autowired
    public PrimeNumberController(PrimeService primeService) {
        this.primeService = primeService;
    }

    @GetMapping("/primes/{number}")
    public PrimeNumber getPrimes(@PathVariable int number) {
        List<Integer> primes = primeService.calculatePrimes(number);
        return new PrimeNumber(number,primes);
    }

}