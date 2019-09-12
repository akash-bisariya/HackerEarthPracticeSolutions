package com.hackerrank.practices.basicInputOutput;

import com.hackerrank.practices.DataStructure.IPracticeSolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromicString implements IPracticeSolution {

    /**
     * Link - https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/palindrome-check-2/
     *
     * @throws IOException
     */


    @Override
    public void startSolution() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        StringBuilder reverse = new StringBuilder();
        for(int i=input.length()-1;i>=0;i--){
            reverse.append(input.charAt(i));
        }

        if(input.equals(reverse.toString()))
            System.out.println("YES");
        else
            System.out.println("NO");


    }
}
