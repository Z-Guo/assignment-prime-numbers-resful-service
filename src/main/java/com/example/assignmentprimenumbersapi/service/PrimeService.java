package com.example.assignmentprimenumbersapi.service;


import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.cache.annotation.Cacheable;

@Service
public class PrimeService {

    @Cacheable("primes")
    public List<Integer> calculatePrimes(int number) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= number; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }

    boolean isPrime(int number) {
        if(number < 2 ) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++){
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }
}