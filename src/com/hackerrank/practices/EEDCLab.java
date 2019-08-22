package com.hackerrank.practices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EEDCLab {
    /**
     * Problem Link - https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/eedc/
     * <p>
     * You must be tired using the Function Generator and the CRO during the EEDC Lab. But the Midsem Lab Test is yet to come.
     * You have to prepare for it and perform all the experiments in order to know the working of those machines.
     * <p>
     * You decide to go to the lab and try those experiments but the lab is locked.
     * The key is with the CC3 guard and he will give you the key only if you answer his queries.
     * <p>
     * The guard loves the numbers divisible by 2,3 and 5.
     * <p>
     * Lucky indices are those index for which the sum of numbers formed using the array elements on its left and
     * array elements on its right is divisible by 2,3 and 5.
     * For example:- Consider the array [1,2,3,4,5] and index 3 (1 - based). The number formed using the array
     * elements on the left is 12 and the number formed using the array elements on the right is 45.
     * <p>
     * So he gives you an array of integers and asks you Q queries. In each query he provides you two integers L and R.
     * You have to answer how many lucky indices are there between L to R (both inclusive).
     * <p>
     * See sample for more clarity.
     * <p>
     * Input Format:
     * <p>
     * First line contains an integer N, which denotes the length of the array A.
     * Second line contains N space-separated integers.
     * Next line contains number of queries Q.
     * Next Q lines contain two integers L and R.
     * <p>
     * Output Format
     * <p>
     * For each query, print the number of lucky indices present in that range.
     * <p>
     * Constraints
     * <p>
     * 1 ≤  ≤ 6
     * <p>
     * <p>
     * Problem Setter - Harsh Jain
     * <p>
     * SAMPLE INPUT
     * 7
     * 1 5 7 5 6 7 5
     * 5
     * 1 2
     * 2 3
     * 4 6
     * 1 7
     * 3 6
     * SAMPLE OUTPUT
     * 0
     * 0
     * 1
     * 1
     * 1
     * Explanation
     * For
     * Index 1: Left Number: 0 and Right Number: 575675
     * Index 2: Left Number: 1 and Right Number: 75675
     * Index 3: Left Number: 15 and Right Number: 5675
     * Index 4: Left Number: 157  and Right Number: 675
     * Index 5: Left Number: 1575 and Right Number: 75
     * Index 6: Left Number: 15756 and Right Number: 5
     * Index 7: Left Number: 157567 and Right Number: 0
     * Only sum of numbers at index 5 is divisible by 2,3 and 5
     */

    public static void startSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int queries = Integer.parseInt(br.readLine());
        long total = 0;
        for (int i = 0; i < queries; i++) {
            String[] qr = br.readLine().split(" ");
            int l = Integer.parseInt(qr[0]) - 1;
            int r = Integer.parseInt(qr[1]) - 1;
            int count=0;
            while (l <= r) {
                total = getLeftNumber(arr, l) + getRightNumber(arr, l);
                if (total % 2 == 0 && total % 3 == 0 && total % 5 == 0) {
                    count++;
                }
                l++;
            }
            System.out.println(count);
        }
    }

    private static long getLeftNumber(String[] arr, int l) {
        StringBuilder num = new StringBuilder();
        if (l == 0)
            return 0;
        else {
            for (int i = 0; i < l; i++) {
                num.append(arr[i]);
            }
        }
        return Long.parseLong(num.toString());
    }

    private static long getRightNumber(String[] arr, int l) {
        StringBuilder num = new StringBuilder();
        if (l >= arr.length-1)
            return 0;
        else {
            for (int i = l + 1; i < arr.length; i++) {
                num.append(arr[i]);
            }
        }
        return Long.parseLong(num.toString());
    }

}
