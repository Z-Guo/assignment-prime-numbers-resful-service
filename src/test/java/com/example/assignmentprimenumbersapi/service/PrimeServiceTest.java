package com.example.assignmentprimenumbersapi.service;


import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class PrimeServiceTest {

 private final PrimeService primeService = new PrimeService();
    @Test
    void testCalculatePrimes() {

        int number = 10;
        List<Integer> primes = primeService.calculatePrimes(number);
        List<Integer> expectedPrimes = Arrays.asList(2,3, 5,7);

        assertEquals(expectedPrimes,primes);
    }

    @Test
    void testCalculatePrimesWithNegative() {
        int number = -5;
        List<Integer> primes = primeService.calculatePrimes(number);
        List<Integer> expectedPrimes = Arrays.asList();

        assertEquals(expectedPrimes,primes);

    }

    @Test
    void testIsPrime() {
        assertTrue(primeService.isPrime(11));
    }

    @Test
    void testNotPrime(){
        assertTrue(!primeService.isPrime(99));
    }


}