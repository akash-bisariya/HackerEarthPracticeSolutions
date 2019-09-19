package com.hackerrank.practices.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumGoodness implements IPracticeSolution {
    /**
     * https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/maximum-goodness/
     *
     * @throws IOException 14
     *                     1 1 1 1 0 0 1 1 0 0 0 1 0 0
     */

    @Override
    public void startSolution() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();

        String[] array = bufferedReader.readLine().split(" ");
        int numberOfOnes = 0;
        int numberOfZeroes = 0;
        int length = 0, maxLength = 0;
        int diff = 0, maxDiff = 0;
        for (int i = 0; i < array.length; i++) {

            if (array[i].equals("1"))
                numberOfOnes++;
            else
                numberOfZeroes++;

            length++;

            diff = Math.abs(numberOfOnes - numberOfZeroes);
            if (maxDiff <= diff) {
                maxDiff = diff;
            }
            if (diff >= maxDiff) {
                maxLength = length;
            }

        }
        System.out.println(maxLength);

        System.out.println("Starting new solution");
        int ones=0;
        int zeroes=0;
        for(int i=0;i<array.length;i++){

            if (array[i].equals("1"))
                ones++;
            else
                zeroes++;

            System.out.println("Ones "+ones+"----- Zeroes "+zeroes+"-------- diff "+Math.abs(ones-zeroes)+"+++++ "+i);

        }





        //22 0s
        //14 1s

    }
}
