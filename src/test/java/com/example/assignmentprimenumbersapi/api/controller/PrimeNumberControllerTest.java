package com.example.assignmentprimenumbersapi.api.controller;

import com.example.assignmentprimenumbersapi.api.model.PrimeNumber;
import com.example.assignmentprimenumbersapi.service.PrimeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class PrimeNumberControllerTest {

        @Mock private PrimeService primeService;

        @InjectMocks private PrimeNumberController primeNumberController;

        @Test
        void shouldReturnPrimesListWithValidInput() {
            int input = 10;
            List<Integer> expectedPrimes = Arrays.asList(2, 3, 5, 7);

            when(primeService.calculatePrimes(input)).thenReturn(expectedPrimes);
            PrimeNumber result = primeNumberController.getPrimes(input);

            assertEquals(input, result.getInitial());
            assertEquals(expectedPrimes, result.getPrimes());
    }
}