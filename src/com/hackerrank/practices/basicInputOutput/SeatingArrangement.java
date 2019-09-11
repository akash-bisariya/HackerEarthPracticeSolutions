package com.hackerrank.practices.basicInputOutput;

import com.hackerrank.practices.DataStructure.IPracticeSolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SeatingArrangement implements IPracticeSolution {
    /**
     * problem link - https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/seating-arrangement-1/
     */

    @Override
    public void startSolution() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < testCases; i++) {
            int seatNumber = Integer.parseInt(bufferedReader.readLine());

            switch (seatNumber % 12) {
                case 1:
                    System.out.println(seatNumber + 11 + " WS");
                    break;
                case 2:
                    System.out.println(seatNumber + 9 + " MS");
                    break;
                case 3:
                    System.out.println(seatNumber + 7 + " AS");
                    break;
                case 4:
                    System.out.println(seatNumber + 5 + " AS");
                    break;
                case 5:
                    System.out.println(seatNumber + 3 + " MS");
                    break;
                case 6:
                    System.out.println(seatNumber + 1+ " WS");
                    break;
                case 7:
                    System.out.println(seatNumber - 1 + " WS");
                    break;
                case 8:
                    System.out.println(seatNumber - 3 + " MS");
                    break;
                case 9:
                    System.out.println(seatNumber - 5 + " AS");
                    break;
                case 10:
                    System.out.println(seatNumber - 7 + " AS");
                    break;
                case 11:
                    System.out.println(seatNumber - 9 + " MS");
                    break;
                case 0:
                    System.out.println(seatNumber - 11 + " WS");
                    break;
            }
        }
    }


}
