# Prime Numbers Restful Service 

This is a Spring Boot-based project to provide a RESTful service that returns prime numbers up to a specified input value. 

## Prerequisites
- [Java 17](https://www.oracle.com/java/technologies/downloads/#java17)
- [Maven 3x](https://maven.apache.org/download.cgi)
- [Git](https://git-scm.com/)

## Install

Clone and use Maven to build
`mvn clean install` 

## Usage
### Calculate The Prime Numbers
Get the prime numbers up until a given number. The response includes both the input number and the list of prime numbers up to the specified number. 

- URL: `primes/{number}`
- Method: `GET`

#### Parameters
- `{number}` **required**: upper limit for generating prime numbers 
- `algorithm` **optional**: select a different algorithm for generating prime numbers, default it not specified 
  - `sieve`: Sieve of Eratosthenes algorithm


#### Response in JSON
`Content-Type: application/json` 
```json
{
    "initial": 9,
    "primes": [
        2,
        3,
        5,
        7
    ]
}
```

#### Response in XML 
`Content-Type: application/xml` 
```xml
<PrimeNumber>
    <initial>9</initial>
    <primes>
        <primes>2</primes>
        <primes>3</primes>
        <primes>5</primes>
        <primes>7</primes>
    </primes>
</PrimeNumber>
```


## Frameworks/Libraries
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
