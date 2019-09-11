package com.hackerrank.practices.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DistributionOfToysFinalAccepted implements IPracticeSolution {

    /**
     * You are playing with N toys. All the toys are identical. It is your duty to distribute all the toys among your other three friends.
     * After the distribution of toys, the person with the highest number of toys is the winner.
     * There can be more than one winner if more than one person has the highest number of toys.
     * You do not want to declare more than one winner. Each of them must have at least one toy otherwise the friends get angry.
     * Your task is to determine the number of ways the toys can be distributed among your three friends
     * so that there is not more than one winner and all of them contain at least one toy.
     *
     * Input format
     *
     * First line: T denoting the number of test cases
     * Each of the next T lines: A single integer N  the number of toys for a round
     * Output format
     * For each test case, print a single line containing one integer
     * that denotes the number of ways to distribute the toys satisfying the mentioned conditions.
     *
     * Constraints
     *
     *
     * SAMPLE INPUT
     * 1
     * 5
     * SAMPLE OUTPUT
     * 3
     * Explanation
     * For , Will can distribute in the following 3 ways, (1,1,3), (1,3,1) (3,1,1)
     * @throws IOException
     */

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
