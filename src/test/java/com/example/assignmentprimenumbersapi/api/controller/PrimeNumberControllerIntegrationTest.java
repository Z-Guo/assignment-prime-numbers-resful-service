package com.example.assignmentprimenumbersapi.api.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.assignmentprimenumbersapi.service.PrimeService;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
class PrimeNumberControllerIntegrationTest {

  @Autowired private MockMvc mockMvc;

  @MockBean private PrimeService primeService;

  @Test
  void shouldReturnDefaultPrimes() throws Exception {
    int n = 13;

    when(primeService.defaultCalculatePrimes(n)).thenReturn(Arrays.asList(2, 3, 5, 7, 11, 13));

    mockMvc
        .perform(get("/primes/{n}", n))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.initial").value("13"))
        .andExpect(jsonPath("$.primes").isArray());
    verify(primeService).defaultCalculatePrimes(n);
  }

  @Test
  void shouldReturnSievePrimes() throws Exception {
    int n = 17;

    when(primeService.sieveCalculatePrimes(n)).thenReturn(Arrays.asList(2, 3, 5, 7, 11, 13, 17));

    mockMvc
        .perform(get("/primes/{n}", n).param("algorithm", "sieve"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.initial").value("17"))
        .andExpect(jsonPath("$.primes").isArray());
    verify(primeService).sieveCalculatePrimes(n);
  }
}
