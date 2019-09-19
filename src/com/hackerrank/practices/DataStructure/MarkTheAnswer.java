package com.hackerrank.practices.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MarkTheAnswer implements IPracticeSolution {

    /**
     * https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/mark-the-answer-1/
     * @throws IOException
     */
    @Override
    public void startSolution() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] size = bufferedReader.readLine().split(" ");
        String[] input = bufferedReader.readLine().split(" ");
        int count=0;
        int maxDifficulty = Integer.parseInt(size[1]);
        int skipCount=0;
        for(int i=0;i<input.length;i++){

            if(Integer.parseInt(input[i])<=maxDifficulty && skipCount<=1){
                count++;
            }
            else
                skipCount++;
        }

        System.out.println(count);

    }
}
