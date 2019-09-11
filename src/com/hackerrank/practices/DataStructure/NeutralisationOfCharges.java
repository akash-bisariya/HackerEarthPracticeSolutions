package com.hackerrank.practices.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NeutralisationOfCharges {
    /**
     * Problem Link - https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/charges-repel/
     *
     * In a parallel universe, there are not just two charges like positive and negative, but there are  charges represented by   english alphabets.
     *
     * Charges have a property of killing each other or in other words neutralizing each other if they are of same charge and next to each other.
     *
     * You are given a string  where each  represents a charge, where .
     *
     * You need to output  of final string followed by string after which no neutralizing is possible.
     *
     * SAMPLE INPUT
     * 12
     * aaacccbbcccd
     * SAMPLE OUTPUT
     * 2
     * ad
     * Explanation
     * aaacccbbcccd -> accd -> ad
     */

    public static void startSolution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine()); //size
        String arr = br.readLine();
        StringBuilder arrCopy = new StringBuilder(arr);
        int n = arrCopy.length();
        for(int i=1;i<n;i++){
            if(arrCopy.charAt(i)==arrCopy.charAt(i-1)){
                arrCopy.deleteCharAt(i-1);
                arrCopy.deleteCharAt(i-1);
                i--;
                n=n-2;
                if(i!=0)
                    i--;
            }
        }
        System.out.println(arrCopy.length());
        System.out.println(arrCopy);
        long[] a={5,7};
        int f=a.length;
    }


}
