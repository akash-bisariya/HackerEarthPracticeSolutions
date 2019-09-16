package com.hackerrank.practices.basicInputOutput;

import com.hackerrank.practices.DataStructure.IPracticeSolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MagicalWord implements IPracticeSolution {
    @Override
    public void startSolution() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < testCases; i++) {
            StringBuilder convertedMagicalString = new StringBuilder();
            bufferedReader.readLine();
            String magical = bufferedReader.readLine();


            for (int j = 0; j < magical.length(); j++) {

                int asciiValue = magical.charAt(j);
                if (asciiValue < 65) {
                    convertedMagicalString.append((char) nextMagicalPrime(65));
                } else {
                    if (!isPrime(asciiValue)) {
                        convertedMagicalString.append((char) nextMagicalPrime(asciiValue));
                    } else {
                        convertedMagicalString.append(magical.charAt(j));
                    }
                }
            }

            System.out.println(convertedMagicalString);
        }

    }

    private boolean isPrime(int num) {
        boolean isPrime = false;
        for (int j = 1; j <= num / 2; j++) {

            if (j != 1 && num % j == 0) {
                isPrime = false;
                break;
            } else
                isPrime = true;

        }
        return isPrime;
    }


    private int nextMagicalPrime(int num) {

        /**
         * for every n>1 there is always at least one prime p such that
         *
         *  n<p<2n
         */
        int nextMagicalPrime = 0;
        int previousPrime = previousPrime(num);
        int nextPrime = nextPrime(num);


        if (num - previousPrime == nextPrime - num) {
            nextMagicalPrime = previousPrime;
        } else if (nextPrime > 122)
            nextMagicalPrime = previousPrime;
        else
            nextMagicalPrime = (num - previousPrime < nextPrime - num) ? previousPrime : nextPrime;

        return nextMagicalPrime;
    }

    private int previousPrime(int num) {
        for (int i = num - 1; i > num / 2; i--) {
            if (isPrime(i))
                return i;
        }
        return 0;
    }

    private int nextPrime(int num) {
        for (int i = num + 1; i < num * 2; i++) {
            if (isPrime(i))
                return i;
        }
        return 0;
    }

}
