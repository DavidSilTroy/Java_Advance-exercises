package it.factory.lambdaprimecalculator;

import it.factory.lambdaprimecalculator.model.PrimeCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class PrimeCalculatorTests {
    PrimeCalculator prime = new PrimeCalculator();

    @Test
    void when_numberCero_isInput_false_isReturned() {
        assertThat(prime.isPrime(0)).isEqualTo(false);
    }

    @Test
    void when_numberOne_isInput_false_isReturned() {
        assertThat(prime.isPrime(1)).isEqualTo(false);
    }

    @Test
    void when_numberTwo_isInput_true_isReturned() {
        assertThat(prime.isPrime(2)).isEqualTo(true);
    }

    @Test
    void when_numberTwoAndTen_isInput_listOfNumbersIncludedTwoAndTen_isReturned() {
        List<Integer> numbersList = asList(2, 3, 4, 5, 6, 7, 8, 9, 10);
        assertThat(prime.getListOfAllNumbersUntil(2, 10)).isEqualTo(numbersList);
    }

    @Test
    void when_numberFifty_isInput_listOfNumbers_isReturned() {
        List<Integer> numbersList = asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47);
        assertThat(prime.getAllPrimeUntil(50)).isEqualTo(numbersList);
    }

}
