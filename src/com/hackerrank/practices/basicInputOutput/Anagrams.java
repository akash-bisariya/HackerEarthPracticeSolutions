package com.hackerrank.practices.basicInputOutput;

import com.hackerrank.practices.DataStructure.IPracticeSolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Anagrams implements IPracticeSolution {

    /**
     * Problem link - https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/anagrams-651/
     *
     * @throws IOException
     */


    @Override
    public void startSolution() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine());

        for(int i=0;i<testCases;i++){
            int count=0;
            int[] array = new int[26];
            String firstString = bufferedReader.readLine();
            String secondString = bufferedReader.readLine();

            for(int j=0;j<firstString.length();j++){
                array[((int)firstString.charAt(j))-'a']--;
            }

            for(int j=0;j<secondString.length();j++){
                array[((int)secondString.charAt(j))-'a']++;
            }

            for(int j=0;j<array.length;j++){
                count =count + Math.abs(array[j]);
            }

            System.out.println(count);

        }




    }
}
