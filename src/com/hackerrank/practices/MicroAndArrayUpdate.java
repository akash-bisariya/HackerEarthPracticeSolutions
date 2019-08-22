package com.hackerrank.practices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MicroAndArrayUpdate {
    /**
     * Micro purchased an array A having N integer values. After playing it for a while, he got bored of it and decided to update value of its element.
     * In one second he can increase value of each array element by 1.
     * He wants each array element's value to become greater than or equal to K.
     * Please help Micro to find out the minimum amount of time it will take, for him to do so.
     *
     * Input:
     * First line consists of a single integer, T, denoting the number of test cases.
     * First line of each test case consists of two space separated integers denoting N and K.
     * Second line of each test case consists of N space separated integers denoting the array A.
     *
     * Output:
     * For each test case, print the minimum time in which all array elements will become greater than or equal to K.
     * Print a new line after each test case.
     *
     * Constraints:
     *
     *
     *
     * SAMPLE INPUT
     * 2
     * 3 4
     * 1 2 5
     * 3 2
     * 2 5 5
     * SAMPLE OUTPUT
     * 3
     * 0
     */

    public static void startSolution() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testcases = Integer.parseInt(bufferedReader.readLine());

        for(int i=0;i<testcases;i++){
            String[] in = bufferedReader.readLine().split(" ");
            int size = Integer.parseInt(in[0]);
            int threshold = Integer.parseInt(in[1]);

            String[] arr = bufferedReader.readLine().split(" ");

            int min=0;
            for(int j=0;j<arr.length;j++){
                if(threshold - Integer.parseInt(arr[j])>0){
                    if(min <(threshold - Integer.parseInt(arr[j])))
                        min= threshold - Integer.parseInt(arr[j]);
                }

            }
            System.out.println(min);

        }


    }

}
