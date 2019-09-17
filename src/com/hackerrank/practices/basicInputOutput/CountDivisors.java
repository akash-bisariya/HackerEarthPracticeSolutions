package com.hackerrank.practices.basicInputOutput;

import com.hackerrank.practices.DataStructure.IPracticeSolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountDivisors implements IPracticeSolution {

    /**
     * Link - https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/count-divisors/
     * @throws IOException
     */

    @Override
    public void startSolution() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        int l = Integer.parseInt(input[0]);
        int r = Integer.parseInt(input[1]);
        int divisor = Integer.parseInt(input[2]);
        int count=0;
        for(int i=l;i<=r;i++ ){
            if(i%divisor==0)
                count++;
        }

        System.out.println(count);
    }
}
