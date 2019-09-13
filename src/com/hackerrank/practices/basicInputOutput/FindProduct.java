package com.hackerrank.practices.basicInputOutput;

import com.hackerrank.practices.DataStructure.IPracticeSolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindProduct implements IPracticeSolution {

    /**
     * Link - https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/find-product/
     * @throws IOException
     */

    @Override
    public void startSolution() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        String[] input = bufferedReader.readLine().split(" ");

        int product = 1;
        int m = 1000000007;
        for (int i=0;i<input.length;i++){
//            product = ((product%m)*((Integer.parseInt(input[i]))%m))%m;
            product = ((product%m)*Integer.parseInt(input[i]))%m;
        }

        System.out.println(product);

    }
}
