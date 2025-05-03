package org.AlexandreLoiola;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main2 {
    public static void main(String[] args) {
        List<Integer> randomNumbers = generateRandomNumbers(1000);
        System.out.println(randomNumbers);
    }

    public static List<Integer> generateRandomNumbers(int size) {
        Random random = new Random();
        List<Integer> randomNumbers = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            randomNumbers.add(random.nextInt(10000) - 5000); // Gera números entre -500 e 499
        }

        return randomNumbers;
    }
}