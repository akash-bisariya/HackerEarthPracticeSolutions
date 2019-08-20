package com.hackerrank.practices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NotInRange {
    /**
     * problem link - https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/not-in-range-44d19403/
     * You are given 10^6 boxes that are numbered from 1 to 10^6. The value of each box is equal to its number.
     * There are  ranges and every range consists of two integers L  and R   denoting that the value of box in the range  will turn out to be zero.
     * Find the sum of values of all boxes from  to  .
     *
     * Note: The ranges may overlap.
     *
     * Input format
     *
     * First line: Integer
     * Next N lines: Two space-separated integers  and
     * Output format
     * Print a single integer denoting the answer.
     *
     * Constraints
     *
     *
     * SAMPLE INPUT
     * 5
     * 2 20
     * 23 200
     * 21 21
     * 101 2000
     * 2002 999998
     * SAMPLE OUTPUT
     * 2002023
     * Explanation
     * Boxes having number 1, 22, 2001, 999999,1000000 does not belong to any range.
     * So the sum of these numbers is 2002023 which is our answer.
     */

    public static void startSolution() throws IOException {
        int[] tempArray = new int[1000001];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        for(int i=0;i<testCases;i++){
            String[] range = br.readLine().split(" ");
            int L = Integer.parseInt(range[0]);
            int R = Integer.parseInt(range[1]);
            for(int j=L;j<=R;j++){
                tempArray[j]=1;
            }
        }
        int sum=0;
        for(int k=0;k<tempArray.length;k++){
            if(tempArray[k]==0)
                sum = sum + k;
        }

        System.out.println(sum);
    }

}
