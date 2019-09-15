package com.hackerrank.practices.basicInputOutput;

import com.hackerrank.practices.DataStructure.IPracticeSolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CostOfBalloons implements IPracticeSolution {

    /**
     * Problem Link - https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/mojtaba-prepares-contest-29b2a044/
     *
     * @throws IOException
     */

    @Override
    public void startSolution() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine());

        int minCost = 0;

        for (int i = 0; i < testCases; i++) {

            String[] costArray = bufferedReader.readLine().split(" ");
            int minValue = 0;
            int maxValue = 0;
            if (Integer.parseInt(costArray[0]) > Integer.parseInt(costArray[1])) {
                minValue = Integer.parseInt(costArray[1]);
                maxValue = Integer.parseInt(costArray[0]);
            } else {
                minValue = Integer.parseInt(costArray[0]);
                maxValue = Integer.parseInt(costArray[1]);
            }

            int size = Integer.parseInt(bufferedReader.readLine());

            int firstWin = 0;
            int secondWin = 0;

            for (int j = 0; j < size; j++) {

                String problems = bufferedReader.readLine();
                firstWin = firstWin + (problems.charAt(0) - '0');
                secondWin = secondWin + (problems.charAt(2) - '0');

            }

            if (firstWin > secondWin) {
                minCost = firstWin * minValue + secondWin * maxValue;
            } else {
                minCost = firstWin * maxValue + secondWin * minValue;
            }


            System.out.println(minCost);

        }

    }
}
