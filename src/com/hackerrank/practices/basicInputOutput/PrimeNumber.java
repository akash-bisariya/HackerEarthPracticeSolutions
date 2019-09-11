package com.hackerrank.practices.basicInputOutput;

import com.hackerrank.practices.DataStructure.IPracticeSolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeNumber implements IPracticeSolution {

    @Override
    public void startSolution() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());

        for (int i = 1; i <= num; i++) {
            boolean isPrime = false;


            for (int j = 1; j <= i / 2; j++) {

                if (j != 1 && i % j == 0) {
                    isPrime = false;
                    break;
                } else
                    isPrime = true;

            }
            if (isPrime)
                System.out.print(i + " ");
        }


    }
}
