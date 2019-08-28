package com.hackerrank.practices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class DistributionOfToysFinalAccepted implements IPracticeSolution {
    @Override
    public void startSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCases; i++) {
            int permutationCount = 0;
            int numOfToys = Integer.parseInt(br.readLine());
            int firstMax = numOfToys / 3 + 1;

            do {
                int remain = numOfToys - firstMax;
                for (int j = 1; j <= remain / 2; j++) {
                    if (j < firstMax && (remain - j) < firstMax && (remain - j + firstMax <= numOfToys)) {
                        if (j - (remain - j) == 0 || remain - j - firstMax == 0)
                            permutationCount = permutationCount + 3;
                        else
                            permutationCount = permutationCount + 6;
                    }
                }
                firstMax++;
            } while (firstMax <= numOfToys - 2);

            System.out.println(permutationCount);
        }
    }
}
