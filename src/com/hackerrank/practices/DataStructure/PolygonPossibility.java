package com.hackerrank.practices.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PolygonPossibility {
    /**
     * Problem Link - https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/polygon-possible/
     *
     * You are given length of n sides, you need to answer whether it is possible to make n sided convex polygon with it.
     *
     * Input : -
     *
     * First line contains ,no .of testcases.
     *
     * For each test case , first line consist of single integer ,second line consist of  spaced integers, size of each side.
     *
     * Output : -
     *
     * For each test case print "Yes" if it is possible to make polygon or else "No" if it is not possible.
     *
     *
     *
     *
     * SAMPLE INPUT
     * 2
     * 3
     * 4 3 2
     * 4
     * 1 2 1 4
     *
     */

    public static void startSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for(int i=0;i<testCases;i++){
            int size = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().split(" ");

            int largestSideIndex = getLargest(arr);
            int remainingSum = 0;
            for(int j=0;j<arr.length;j++){
                if(j!=largestSideIndex){
                    remainingSum = remainingSum + Integer.parseInt(arr[j]);
                }
            }

            if(Integer.parseInt(arr[largestSideIndex])<remainingSum)
                System.out.println("Yes");
            else
                System.out.println("No");


        }

    }

    private static int getLargest(String[] arr){
        int largestIndex = 0;
        for(int i=0;i<arr.length;i++){
            if(Integer.parseInt(arr[largestIndex])<Integer.parseInt(arr[i]))
                largestIndex=i;
        }
        return largestIndex;
    }

}


