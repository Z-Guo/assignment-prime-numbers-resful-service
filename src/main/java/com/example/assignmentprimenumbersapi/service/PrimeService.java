package com.example.assignmentprimenumbersapi.service;

import java.util.*;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class PrimeService {

  @Cacheable("primesDefault")
  public List<Integer> defaultCalculatePrimes(int number) {
    List<Integer> primes = new ArrayList<>();
    for (int i = 2; i <= number; i++) {
      if (isPrime(i)) {
        primes.add(i);
      }
    }
    return primes;
  }

  boolean isPrime(int number) {
    if (number < 2) {
      return false;
    }
    for (int i = 2; i <= Math.sqrt(number); i++) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }

  @Cacheable("primesSieve")

  public List<Integer> sieveCalculatePrimes(int number) {
    boolean[] isPrime = new boolean[Math.max(number, 1) + 1];
    Arrays.fill(isPrime, true);

    if (number <= 1) {
      return Collections.emptyList();
    }

    for (int i = 2; i <= Math.sqrt(number); i++) {
      if (isPrime[i]) {
        for (int j = i * i; j <= number; j += i) {
          isPrime[j] = false;
        }
      }
    }

    List<Integer> primes = new ArrayList<>();
    for (int i = 2; i <= number; i++) {
      if (isPrime[i]) {
        primes.add(i);
      }
    }
    return primes;
  }
}
