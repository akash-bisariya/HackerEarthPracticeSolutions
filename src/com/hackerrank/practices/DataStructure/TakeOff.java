package com.hackerrank.practices.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TakeOff {
    /**
     * There are three planes , A, B and C.
     * Plane A will takeoff on every pth day i.e. p, 2p , 3p and so on.
     * Plane B will takeoff on every qth day and plane C will takeoff on every rth day.
     * There is only one runway and the takeoff timing is same for each of the three planes on each day.
     * Your task is to find out the maximum number of flights that will successfully takeoff in the period of  days.
     * Note: If there is collision between the flights no flight will take off on that day.
     *
     * Input Format
     * The first line of the input contains a single integer , the number of test cases.
     * Then  lines follow each containing four space-separated integers , ,  and  as denoted in the statement.
     *
     * Output Format
     * For each test case print a single integer representing the maximum number of flights that will successfully takeoff
     * in the period of  days.
     *
     * Constraints
     *
     * SAMPLE INPUT
     * 2
     * 10 2 3 4
     * 10 2 2 4
     * SAMPLE OUTPUT
     * 4
     * 0
     * Explanation
     * Sample test case 1:
     * Note that on days 2 and 10 plane A can takeoff, on days 3 and 9 plane B can takeoff.
     *
     * Sample test case 2:
     * Note that there is no day on which there is no collision.
     */

    public static void startSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for(int i=0;i<testCase;i++){
            String[] input = br.readLine().split(" ");
            int days = Integer.parseInt(input[0]);

            int p = Integer.parseInt(input[1]);
            int q = Integer.parseInt(input[2]);
            int r = Integer.parseInt(input[3]);

            int total=0;
            total = total + getCount(p,q,r,days)+getCount(q,p,r,days)+getCount(r,q,p,days);

            System.out.println(total);
        }


    }


    private static int getCount(int p,int q,int r,int days){
        int p1=p,q1=q,r1=r,count=0;
        while(p<=days){
            boolean match = false;
            while(q<=days){
                if(p==q) {
                    match = true;
                    break;
                }
                q= q+q1;
            }
            while(r<=days){
                if(p==r){
                    match = true;
                    break;
                }
                r=r+r1;
            }
            if(!match)
                count++;

            p = p+p1;
            q = q1;
            r = r1;
        }
        return count;
    }

}
