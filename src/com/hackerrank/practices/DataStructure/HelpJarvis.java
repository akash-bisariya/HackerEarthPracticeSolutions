package com.hackerrank.practices.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HelpJarvis {

    /**
     * Tony Stark is in the planet Titan crying for his friends are turning into ashes, and on earth mayhem has ensued since a lot of people are turning into ashes too.
     * Some trains have been derailed in such a way that a lot of its coaches are thrown off in a random disarray like coach 3, 4 and 5 are thrown off in one place,
     * coach 2 and 6 are thrown off in another place, etc.
     *
     * S.H.I.E.L.D calls upon Hulk and jarvis to help them collect and connect some the thrown off coaches of those trains,
     * but a train can only move if the collected coaches number are in a continuous manner (need not to be in order) ,like 1234, 2314, 4123, 2341  etc.
     *
     * Help Jarvis write a program for hulk to decide whether collected coaches will move or not.
     *
     * Input Format:
     *
     * First ilne contains one number t , denoting the number of test cases.
     *
     * Next t lines contain sequence of the collected coach numbers (n)
     *
     * Output Format:
     *
     * YES or NO (In capitals)
     *
     * Input constraints:
     *
     * 1 <= t <= 10000
     *
     * 1<= n <= 1000000
     *
     * SAMPLE INPUT
     * 6
     * 241524152415
     * 4231
     * 4125
     * 5142
     * 4132
     * 2143
     * SAMPLE OUTPUT
     * NO
     * YES
     * NO
     * NO
     * YES
     * YES
     */

    public static void startSolution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberOfTestCases = Integer.parseInt(br.readLine());

//        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=0;i<numberOfTestCases;i++){
            String inputString = br.readLine();
            int size=inputString.length();
            int[] input=new int[size];

            int[] indexedArray = new int[10];
            for(int j=0;j<inputString.length();j++)
            {
                input[j] = inputString.charAt(j)-'0';
                indexedArray[input[j]]++;
            }

            int min =input[0];
            int max=input[0];

            for(int l=0;l<input.length;l++){
                if(max<input[l])
                    max = input[l];
                if(min>input[l])
                    min = input[l];
            }
            boolean chk=false;
            int count=0;
            for(int k=min;k<=max;k++){
                if(indexedArray[k]==0){
                   chk = true;
                   break;
                }
                else{
                    chk = false;
                    count++;
                }
                min++;
            }
            if(!chk && count==input.length)
                System.out.println("YES");
            else
                System.out.println("NO");


        }

    }



}
