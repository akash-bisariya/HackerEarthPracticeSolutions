package com.hackerrank.practices.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ChargedUpArray {
    /**
     * Problem Link - https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/charged-up-array-f35a5e23/
     * <p>
     * You are given with an array A of size N.An element Ai is said to be charged if its value(Ai) is greater than or equal to Ki.Ki is the total
     * number of subsets of array A, that consist of element Ai.
     * Total charge value of the array is defined as summation of all charged elements present in the array mod 109+7.
     * Your task is to output the total charge value of the given array A.
     * <p>
     * INPUT FORMAT:
     * <p>
     * The first line of input contains number of test cases .
     * The first line of each test case consists of , the size of the array.
     * Next line contains  space-separated integers corresponding to each element .
     * <p>
     * OUTPUT FORMAT:
     * <p>
     * For each test case, output a single number corresponding to total charge value of the given array.
     * <p>
     * CONSTRAINTS:
     * <p>
     * SAMPLE INPUT
     * 2
     * 3
     * 3 4 5
     * 2
     * 1 6
     * SAMPLE OUTPUT
     * 9
     * 6
     * Explanation
     * <p>
     * CASE 1:
     * Possible subsets are: {3}, {4}, {5}, {3,4}, {3,5}, {4,5}, {3,4,5}, {}.
     * Element 3 is present in 4 subsets. As 3<4, it is not charged.
     * Element 4 is present in 4 subsets. As 4>=4, it is charged.
     * Element 5 is present in 4 subsets. As 5>=4, it is charged.
     * Total charge=4+5=9
     * <p>
     * CASE 2:
     * Possible subsets are: {1}, {6}, {1,6}, {}.
     * Element 1 is present in 2 subsets. As 1<2, it is not charged.
     * Element 6 is present in 2 subsets. As 6>=2, it is charged.
     * Total charge=6
     */

    public static void startSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for (int t_i = 0; t_i < T; t_i++) {
            int N = Integer.parseInt(br.readLine().trim());
            String[] arr_A = br.readLine().split(" ");
            long[] A = new long[N];
            for (int i_A = 0; i_A < arr_A.length; i_A++) {
                A[i_A] = Long.parseLong(arr_A[i_A]);
            }

            long out_ = solve(A, N);
            System.out.println(out_);
            System.out.println("");
        }

        wr.close();
        br.close();
    }

    private static long solve(long[] A, int N) {
        long subset = 1;
        if (A.length > 60) {
            return 0;
        } else {
            for (int i = 0; i < A.length - 1; i++) {
                subset = ((subset)) * 2;
            }
            long sum = 0;
            for (int i = 0; i < A.length; i++) {
                if (A[i] >= subset)
                    sum = sum + A[i];
            }
            return sum % 1000000007;
        }

    }
}

