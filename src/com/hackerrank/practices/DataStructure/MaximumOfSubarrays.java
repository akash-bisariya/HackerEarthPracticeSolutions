package com.hackerrank.practices.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumOfSubarrays {
    /**
     * Problem link - https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/maximum-of-k-size-subarrays-deque/
     */


    public static void startSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sizeArr = br.readLine().split(" ");
        int k = Integer.parseInt(sizeArr[1]);
        String[] arr = br.readLine().split(" ");
        for(int i=0;i<=arr.length-k;i++){
            int max = Integer.parseInt(arr[i]);
            int count=0;
            for(int j=i;count<k;j++){
                if(max<Integer.parseInt(arr[j]))
                    max= Integer.parseInt(arr[j]);
                count++;
            }
            System.out.print(max+" ");
        }

    }


}
