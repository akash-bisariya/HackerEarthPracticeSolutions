package com.hackerrank.practices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PepperAndContiguousEvenSubArray {
    /**
     * Problem Link - https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/pepper-and-contiguous-even-subarray-9f3adf65/
     *
     * This is a DEBUGGING question.
     *
     * You have an array of length N. A subarray is called Interesting if it contains only even numbers. You have to  find the maximum length of such Interesting subarray.
     *
     * You are given a code which does the given task but has some bugs (errors). You have to make changes in the given function such that the code handles all the cases for errors and generate correct output every time.
     *
     * Input
     * First line contains T , denoting number of test cases.
     * Each test case contains two lines:
     *     - First line contains an integer N denoting the size of the array.
     *     - Second line contains N space seperated integers denoting the value of array elements.
     *
     * Ouput:
     * For each test case, print the maximum length of Interesting subarray. If no such subarray exist,print -1.
     *
     * Input Constraints:
     *
     *
     *
     *
     * Note:
     *
     * The input and output is handled by the code itself. You are just supposed to correct the function.
     *
     * SAMPLE INPUT
     * 1
     * 4
     * 5 2 4 7
     * SAMPLE OUTPUT
     * 2
     */
    public static void startSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcases =  Integer.parseInt(br.readLine());

        for(int i=0;i<testcases;i++){
            int size =  Integer.parseInt(br.readLine());
            String[] arr = br.readLine().split(" ");
            int count=0;
            int answer=0;
            for(int j=0;j<size;j++){
                if(Integer.parseInt(arr[j])%2==0){
                    count++;
                    if(answer<count)answer=count;
                }
                else
                    count=0;


            }
            System.out.println(answer);
        }

    }

}
