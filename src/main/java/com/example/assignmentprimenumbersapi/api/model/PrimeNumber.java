package com.example.assignmentprimenumbersapi.api.model;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;


@JacksonXmlRootElement(localName = "PrimeNumber")
public class PrimeNumber {
    private int initial;
    private List<Integer> primes ;

    public PrimeNumber (int initial, List<Integer> primes) {
        this.initial = initial;
        this.primes = primes;
    }

    @JacksonXmlProperty
    public int getInitial() { return initial; }

    public void setInitial(int initial) {this.initial = initial;}
    @JacksonXmlProperty
    public List<Integer> getPrimes() { return primes; }

    public void setPrimes(List<Integer> primes) {
        this.primes = primes;
    }

}