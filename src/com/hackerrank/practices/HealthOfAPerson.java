package com.hackerrank.practices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HealthOfAPerson implements IPracticeSolution {

    /**
     * There N people in your city. The jth person contains Aj health point.
     * You are trying to make these people walk in your locality. You walk for M days.
     * On the ith day, every walk decreases Bi health points of the person you are walking with.
     * Also, on the ith day, you can only walk with the jth person if the person is still healthy and j is a multiple of i.
     * You can walk with as many people as you can but you can walk with a specific person only once in a day.
     *
     * A person becomes unhealthy if their health point becomes less than or equal to . At the end of each day, their health points are restored to their original level if they are not unhealthy already.
     *
     * Your task is to determine the day in which the ith person becomes unhealthy or will remain healthy.
     *
     * Input format
     *
     * First line:  denoting the number of test cases
     * For each test case:
     * First line: Contains two integers N and M denoting the number of people and days on which you walk respectively
     * Next line: N integers where Ai denotes the health points of the ith person
     * Next line: M integers where Bi denotes the reduction of the health of the ith day's walk
     * Output format
     * Print  lines where the ith of these​​​​​ lines contain a single integer, denoting the day when the ith person becomes unhealthy.
     * Otherwise, print -1 if the ith person never becomes unhealthy.
     *
     * Constraints
     *
     *
     *
     *
     * SAMPLE INPUT
     * 2
     * 6 5
     * 2 1 6 4 3 7
     * 2 3 7 3 4
     * 3 3
     * 2 1 3
     * 2 2 2
     * SAMPLE OUTPUT
     * 1
     * 1
     * 3
     * -1
     * 5
     * 3
     * 1
     * 1
     * -1
     * Explanation
     * In the first sample,
     * 1st and 2nd people become unhealthy in the 1st day.
     * 3rd and 6th person becomes unhealthy in the 3rd day.
     * 5th person becomes unhealthy in the 5th day.
     *
     * 4th person remains healthy.
     */


    @Override
    public void startSolution() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine());

        for(int i=0;i<testCases;i++){
            String size = bufferedReader.readLine();
            String[] healthOfPersonArray = bufferedReader.readLine().split(" ");
            String[] healthReduction = bufferedReader.readLine().split(" ");
//            String healthOfPersonArrayLength = size.charAt(0)
            int[] tempArray = new int[healthOfPersonArray.length];
            for(int j=0;j<healthReduction.length;j++){
                int reduction = Integer.parseInt(healthReduction[j]);
                for(int k=0;k<healthOfPersonArray.length;k++) {
                    if (tempArray[k]<=0 && (k + 1) % (j + 1) == 0) {
                        if (Integer.parseInt(healthOfPersonArray[k])- reduction <= 0) {
                            tempArray[k] = j+1;
                        }
                    }
                }
            }
            for(int p : tempArray){
                if(p==0)
                    System.out.println(-1);
                else
                    System.out.println(p);

            }
        }


    }

}
