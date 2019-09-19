package com.hackerrank.practices.basicInputOutput;

import com.hackerrank.practices.DataStructure.IPracticeSolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MonkAndLuckyMinimum implements IPracticeSolution {

    /**
     * https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/monk-and-lucky-minimum-3/description/
     *
     * @throws IOException
     */
    @Override
    public void startSolution() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine());


        for (int i = 0; i < testCases; i++) {
            bufferedReader.readLine();
            String[] inputArray = bufferedReader.readLine().split(" ");
            int count = 0;
            int min = Integer.parseInt(inputArray[0]);
            for (int j = 0; j < inputArray.length; j++) {
                if (min > Integer.parseInt(inputArray[j]))
                    min = Integer.parseInt(inputArray[j]);
            }

            for (int j = 0; j < inputArray.length; j++) {
                if (min == Integer.parseInt(inputArray[j]))
                    count++;
            }

            if(count%2==0)
                System.out.println("Unlucky");
            else
                System.out.println("Lucky");


        }
    }
}
