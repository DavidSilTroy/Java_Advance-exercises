package it.factory.lambdaprimecalculator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PrimeCalculator {

    public boolean isPrime(int number) {
        boolean isItPrime = true;
        if (number <= 1) {
            isItPrime = false;
            return isItPrime;
        } else {
            for (int i = 2; i <= number / 2; i++) {
                if ((number % i) == 0) {
                    isItPrime = false;
                    break;
                }
            }
            return isItPrime;
        }
    }

    public List<Integer> getAllPrimeUntil(int number) {
        List<Integer> numbersList = new ArrayList<>();

        getListOfAllNumbersUntil(2, number).forEach(item ->
        {
            if (isPrime(item)) {
                numbersList.add(item);
            }
        });
        return numbersList;
    }

    public List<Integer> getListOfAllNumbersUntil(int start, int end) {
        List<Integer> numbersList = new ArrayList<>();
        IntStream
                .rangeClosed(start, end)
                .forEach(item -> numbersList.add(item));
        return numbersList;
    }


}
