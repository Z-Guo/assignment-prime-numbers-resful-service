package com.example.assignmentprimenumbersapi.api.model;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;


@JacksonXmlRootElement(localName = "PrimeNumber")
public class PrimeNumber {
    private int initials;
    private List<Integer> primes ;

    public PrimeNumber (int initials, List<Integer> primes) {
        this.initials = initials;
        this.primes = primes;
    }

    @JacksonXmlProperty
    public int getInitials() { return initials; }

    public void setInitials(int initials) {this.initials = initials ;}
    @JacksonXmlProperty
    public List<Integer> getPrimes() { return primes; }

    public void setPrimes(List<Integer> primes) {
        this.primes = primes;
    }

}