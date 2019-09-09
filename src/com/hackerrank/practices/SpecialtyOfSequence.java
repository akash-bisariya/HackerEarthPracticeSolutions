package com.hackerrank.practices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class SpecialtyOfSequence implements IPracticeSolution{

    /**
     * https://www.hackerearth.com/practice/algorithms/sorting/quick-sort/practice-problems/algorithm/lex-finds-beauty-0d0bc1b6/
     */


    @Override
    public void startSolution() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] size = bufferedReader.readLine().split(" ");
        int k = Integer.parseInt(size[1]);
        int sizeArray = Integer.parseInt(size[0]);
        String[] inputArray = bufferedReader.readLine().split(" ");
        int[] intArray=new int[sizeArray];
        int i=0;
        for(String a : inputArray){
            intArray[i] = Integer.parseInt(a);
            i++;
        }

        Arrays.sort(intArray);
        int sum=0;
        for(int j=0;j<intArray.length-2;j++){
            sum =sum + intArray[j];
        }

        System.out.println(sum);

    }
}
