package com.hackerrank.practices.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MonkAndWelcomeProblem {
    /**
     * Having a good previous year, Monk is back to teach algorithms and data structures. This year he welcomes the learners with a problem which he calls "Welcome Problem". The problem gives you two arrays A and B (each array of size N) and asks to print new array C such that:
     *  ;
     * Now, Monk will proceed further when you solve this one. So, go on and solve it :)
     *
     * Input:
     * First line consists of an integer N, denoting the size of A and B.
     * Next line consists of N space separated integers denoting the array A.
     * Next line consists of N space separated integers denoting the array B.
     *
     * Output:
     * Print N space separated integers denoting the array C.
     *
     * Input Constraints:
     *
     * ;
     * ;
     *
     * SAMPLE INPUT
     * 5
     * 1 2 3 4 5
     * 4 5 3 2 10
     * SAMPLE OUTPUT
     * 5 7 6 6 15
     */

    public static void startSolution() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bufferedReader.readLine());

        String[] arr1 = bufferedReader.readLine().split(" ");
        String[] arr2 = bufferedReader.readLine().split(" ");

        for(int i=0;i<size;i++){
            System.out.print(Integer.parseInt(arr1[i])+Integer.parseInt(arr2[i])+" ");
        }

    }

}
