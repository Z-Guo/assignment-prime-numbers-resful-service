package com.example.assignmentprimenumbersapi.api.controller;

import com.example.assignmentprimenumbersapi.api.model.PrimeNumber;
import com.example.assignmentprimenumbersapi.service.PrimeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PrimeNumberController {

  private final PrimeService primeService;

  @Autowired
  public PrimeNumberController(PrimeService primeService) {
    this.primeService = primeService;
  }

  @GetMapping("/primes/{number}")
  public PrimeNumber getPrimes(
      @PathVariable int number,
      @RequestParam(value = "algorithm", required = false) String algorithm) {

    List<Integer> primes;
    if (algorithm != null && algorithm.equalsIgnoreCase("sieve")) {
      primes = primeService.sieveCalculatePrimes(number);
    } else {
      primes = primeService.defaultCalculatePrimes(number);
    }
    return new PrimeNumber(number, primes);
  }
}
