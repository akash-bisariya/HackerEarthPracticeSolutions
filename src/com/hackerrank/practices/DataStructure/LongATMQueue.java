package com.hackerrank.practices.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongATMQueue {
    /**
     * Due to the demonetization move, there is a long queue of people in front of ATMs.
     * Due to withdrawal limit per person per day, people come in groups to withdraw money.
     * Groups come one by one and line up behind the already present queue. The groups have a strange way of arranging themselves.
     * In a particular group, the group members arrange themselves in increasing order of their height(not necessarily strictly increasing).
     *
     * Swapy observes a long queue standing in front of the ATM near his house. Being a curious kid,
     * he wants to count the total number of groups present in the queue waiting to withdraw money.
     * Since groups are standing behind each other, one cannot differentiate between different groups and the exact count cannot be given.
     * Can you tell him the minimum number of groups that can be observed in the queue?
     *
     * Input format:
     * The first line of input contains one positive integer N.
     * The second line contains N space-separated integers  denoting the height of i-th person.
     * Each group has group members standing in increasing order of their height.
     *
     * Output format:
     * Print the minimum number of groups that are at least present in the queue?
     *
     * Constraints:
     * SAMPLE INPUT
     * 4
     * 1 2 3 4
     * SAMPLE OUTPUT
     * 1
     */

    public static void startSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine(); //size
        String[] arr = br.readLine().split(" ");
        int count=1;
        for(int i=0;i<arr.length-1;i++){
            if(Integer.parseInt(arr[i])>Integer.parseInt(arr[i+1]))
                count++;
        }
        System.out.print(count);

    }
}
