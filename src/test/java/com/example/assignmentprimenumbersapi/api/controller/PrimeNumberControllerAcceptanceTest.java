package com.example.assignmentprimenumbersapi.api.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class PrimeNumberControllerAcceptanceTest {

  @Autowired private MockMvc mockMvc;

  @Test
  void shouldReturnDefaultPrimes() throws Exception {
    int n = 13;

    mockMvc
        .perform(get("/primes/{n}", n))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.initial").value("13"))
        .andExpect(jsonPath("$.primes").isArray());
  }

  @Test
  void shouldReturnSievePrimes() throws Exception {
    int n = 17;

    mockMvc
        .perform(get("/primes/{n}", n).param("algorithm", "sieve"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.initial").value("17"))
        .andExpect(jsonPath("$.primes").isArray());
  }
}
