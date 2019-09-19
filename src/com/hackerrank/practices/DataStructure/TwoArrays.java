package com.hackerrank.practices.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoArrays implements IPracticeSolution {

    /**
     * https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/2-arrays-90c9019c/
     *
     * @throws IOException
     */


    @Override
    public void startSolution() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();

        String[] array1 = bufferedReader.readLine().split(" ");
        String[] array2 = bufferedReader.readLine().split(" ");

        int sum1 = 0;
        int sum2 = 0;

        int countOfMinusOne1 = 0;
        int countOfMinusOne2 = 0;

        int count = 0;

        for (int i = 0; i < array1.length; i++) {
            if (Integer.parseInt(array1[i]) != -1)
                sum1 = sum1 + Integer.parseInt(array1[i]);
            else
                countOfMinusOne1++;
            if (Integer.parseInt(array2[i]) != -1)
                sum2 = sum2 + Integer.parseInt(array2[i]);
            else
                countOfMinusOne2++;
        }
        if (sum1 == sum2 || countOfMinusOne1 == countOfMinusOne2)
            System.out.println("Infinite");


        else if (countOfMinusOne1 > 1 || countOfMinusOne2 > 1) {
            if ((countOfMinusOne1 > 1 && sum1 <= sum2) || (countOfMinusOne2 > 1 && sum2 <= sum1))
                System.out.println(Math.abs(sum1 - sum2) + 1);
            else
                System.out.println(0);
        } else {
            if (Math.abs(countOfMinusOne1 - countOfMinusOne2) == 1) {
                if (countOfMinusOne1 >= 1 && sum1 <= sum2) {
                    count++;
                } else if (countOfMinusOne2 >= 1 && sum2 <= sum1) {
                    count++;
                }
            }
            System.out.println(count);

        }


    }
}
