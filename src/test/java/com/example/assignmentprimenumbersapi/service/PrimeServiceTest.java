package com.example.assignmentprimenumbersapi.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class PrimeServiceTest {

  private final PrimeService primeService = new PrimeService();

  @Test
  void testCalculatePrimesDefault() {
    int number = 29;
    List<Integer> primes = primeService.defaultCalculatePrimes(number);
    List<Integer> expectedPrimes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);

    assertEquals(expectedPrimes, primes);
  }

  @Test
  void testCalculatePrimesSieve() {
    int number = 29;
    List<Integer> primes = primeService.sieveCalculatePrimes(number);
    List<Integer> expectedPrimes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);

    assertEquals(expectedPrimes, primes);
  }

  @Test
  void testCalculatePrimesWithNegativeDefault() {
    int number = -5;
    List<Integer> primes = primeService.defaultCalculatePrimes(number);
    List<Integer> expectedPrimes = Collections.emptyList();

    assertEquals(expectedPrimes, primes);
  }

  @Test
  void testCalculatePrimesWithNegativeSieve() {
    int number = -5;
    List<Integer> primes = primeService.sieveCalculatePrimes(number);
    List<Integer> expectedPrimes = Collections.emptyList();

    assertEquals(expectedPrimes, primes);
  }

  @Test
  void testIsPrimeDefault() {
    assertTrue(primeService.isPrime(11));
  }

  @Test
  void testNotPrimeDefault() {
    assertFalse(primeService.isPrime(99));
  }
}
