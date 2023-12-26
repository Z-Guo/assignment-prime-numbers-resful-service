package com.example.assignmentprimenumbersapi.api.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.example.assignmentprimenumbersapi.api.model.PrimeNumber;
import com.example.assignmentprimenumbersapi.service.PrimeService;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PrimeNumberControllerTest {

  private static final int INPUT = 10;
  private static final List<Integer> EXPECTED_PRIMES = Arrays.asList(2, 3, 5, 7);
  @Mock private PrimeService primeService;
  @InjectMocks private PrimeNumberController primeNumberController;

  @Test
  void shouldReturnPrimesWithValidInputDefault() {

    when(primeService.defaultCalculatePrimes(INPUT)).thenReturn(EXPECTED_PRIMES);
    PrimeNumber defaultResult = primeNumberController.getPrimes(INPUT, null);

    assertEquals(INPUT, defaultResult.getInitial());
    assertEquals(EXPECTED_PRIMES, defaultResult.getPrimes());
  }

  @Test
  void shouldReturnPrimesWithValidInputSieve() {

    when(primeService.sieveCalculatePrimes(INPUT)).thenReturn(EXPECTED_PRIMES);
    PrimeNumber sieveResult = primeNumberController.getPrimes(INPUT, "sieve");

    assertEquals(INPUT, sieveResult.getInitial());
    assertEquals(EXPECTED_PRIMES, sieveResult.getPrimes());
  }

  @Test
  void shouldReturnSameResultForDefaultAndSieve() {

    when(primeService.defaultCalculatePrimes(INPUT)).thenReturn(EXPECTED_PRIMES);
    when(primeService.sieveCalculatePrimes(INPUT)).thenReturn(EXPECTED_PRIMES);
    PrimeNumber defaultResult = primeNumberController.getPrimes(INPUT, null);
    PrimeNumber sieveResult = primeNumberController.getPrimes(INPUT, "sieve");

    assertEquals(defaultResult.getPrimes(), sieveResult.getPrimes());
  }
}
