package com.hackerrank.practices.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HamiltonianAndLagrangian {

    /**
     * Students have become secret admirers of SEGP. They find the course exciting and the professors amusing. After a superb Mid Semester examination its now time for the results. The TAs have released the marks of students in the form of an array, where arr[i] represents the marks of the ith student.
     *
     * Since you are a curious kid, you want to find all the marks that are not smaller than those on its right side in the array.
     *
     * Input Format
     * The first line of input will contain a single integer n denoting the number of students.
     * The next line will contain n space separated integers representing the marks of students.
     *
     * Output Format
     * Output all the integers separated in the array from left to right that are not smaller than those on its right side.
     *
     * Constraints
     * 1 <= n <= 1000000
     * 0 <= arr[i] <= 10000
     *
     * Problem Setter - Dhvit
     *
     * SAMPLE INPUT
     * 6
     * 16 17 4 3 5 2
     * SAMPLE OUTPUT
     * 17 5 2
     */

    public static void startSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine(); //size
        String[] arr = br.readLine().split(" ");
        for(int i=0;i<arr.length;i++){
            boolean isGreater = true;
            for(int j=i+1;j<arr.length;j++){
                if(!(Integer.parseInt(arr[i])>Integer.parseInt(arr[j]))){
                    isGreater = false;
                    break;
                }
            }
            if(isGreater)
                System.out.print(arr[i]+" ");
        }
    }
}
