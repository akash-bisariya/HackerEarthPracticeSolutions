package com.hackerrank.SeptemberCircuits19;

import com.hackerrank.practices.DataStructure.IPracticeSolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SmallestChosenWord implements IPracticeSolution {

    /**
     * https://www.hackerearth.com/challenges/competitive/september-circuits-19/algorithm/smallest-chosen-word-0108fd21/
     * @throws IOException
     */

    @Override
    public void startSolution() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] sizes = bufferedReader.readLine().split(" ");

        String[] strings = bufferedReader.readLine().split(" ");

        StringBuilder smallestInLexicographicalOrder= new StringBuilder(strings[0]);

        StringBuilder s2 =new StringBuilder(strings[1]);
        String s3 = strings[2];


        for(int i=0;s2.length()>0;i++){

            char toBeAppended = getMinimum(s2);
            if(toBeAppended<s3.charAt(0)){
                smallestInLexicographicalOrder.append(""+toBeAppended);
            }
            else if(s2.length()==0 && toBeAppended==s3.charAt(0)){
                smallestInLexicographicalOrder.append(""+toBeAppended);
            }

        }

        System.out.println(smallestInLexicographicalOrder.append(s3));





    }

    private static char getMinimum(StringBuilder s) {

        int min = (int)s.charAt(0) - 'a';
        for(int i=0;i<s.length();i++){
            if(min>(int)s.charAt(i)-'a'){
                min = (int)s.charAt(i)-'a';
            }

        }

       for(int j=0;j<s.length();){
           if(s.charAt(j)==(char)(min+'a')){
               s.deleteCharAt(j);
               break;
           }
           else {
               s.deleteCharAt(j);
               j++;
           }
       }

       return (char)(min+'a');

    }


}
