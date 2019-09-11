package com.hackerrank.practices.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StrangeGame {
    /**
     * Alice and Bob are very good friends. They keep on playing some strange games.
     * Today Alice came up with a new game, in which each player gets  cards at the start. Each card has it's value printed on it.
     * The game proceeds as each player chooses a random card and shows it's value.
     * The player having card with higher value wins. As Alice came up with this game,
     * he wants to ensure his win. So he starts to increase value of some cards using an algorithm.
     * To increase the value of a card by , the running time of algorithm is  seconds.
     * Find the minimum running time of algorithm, ensuring the win of Alice.
     *
     * Input:
     * First line of input contains an integer  denoting the number of TestCases.
     * First line of Each testcase contains two Integers  and .
     * Next two lines of each TestCase contains  integers, each denoting value of cards of Alice and Bob respectively.
     *
     * Output:
     * Print a single line for each TestCase, running time of algorithm to ensure the win for Alice.
     *
     * Constraints:
     *
     *
     *
     *
     *
     *
     *
     * SAMPLE INPUT
     * 3
     * 5 3
     * 8 9 10 23 4
     * 7 9 2 3 13
     * 6 8
     * 8 99 23 1 3 0
     * 9 32 22 45 3 2
     * 3 2
     * 1 1 0
     * 5 8 9
     * SAMPLE OUTPUT
     * 75
     * 1560
     * 56
     */

    public static void startSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for(int i=0;i<testCase;i++){
            String inputAndTime = br.readLine();
            int time = Integer.parseInt(inputAndTime.split(" ")[1]);

            String[] alice = br.readLine().split(" ");
            String[] bob = br.readLine().split(" ");
            int maxValueBob = Integer.parseInt(bob[0]);
            for(int j=0;j<bob.length;j++){
                if(maxValueBob<Integer.parseInt(bob[j]))
                    maxValueBob= Integer.parseInt(bob[j]);
            }
            long totalTime=0;
            for(int k=0;k<alice.length;k++){
                if(Integer.parseInt(alice[k])<=maxValueBob){
                    totalTime = totalTime + ((maxValueBob+1)-Integer.parseInt(alice[k]))*time;
                }
            }

            System.out.println(totalTime);

        }

    }


}
