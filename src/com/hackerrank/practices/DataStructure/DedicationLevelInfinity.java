package com.hackerrank.practices.DataStructure;

import javax.imageio.IIOParamController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DedicationLevelInfinity implements IPracticeSolution {
    /**
     * https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/baaki-che/
     *
     * @throws IOException
     */

    @Override
    public void startSolution() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine());
        String[] input = new String[testCases];
        int[] times = new int[testCases];
        int firstCoder = 0;
        int secondCoder = 0;
        int thirdCoder = 0;

        for (int i = 0; i < testCases; i++) {

            input[i] = bufferedReader.readLine();
            times[i] = Integer.parseInt(input[i].split(" ")[1]);

        }
        for (int i = 0; i < times.length; i++) {

            if (times[i] > firstCoder) {
                thirdCoder = secondCoder;
                secondCoder = firstCoder;
                firstCoder = times[i];

            } else if (times[i] > secondCoder) {

                thirdCoder = secondCoder;
                secondCoder = times[i];

            } else if (times[i] > thirdCoder) {

                thirdCoder = times[i];

            }
        }


       printCoder(firstCoder,input);
       printCoder(secondCoder,input);
       printCoder(thirdCoder,input);


    }

    private static void printCoder(int time, String[] input){
        for (String s : input) {
            String[] coder = s.split(" ");
            if (coder[1].equals(time + ""))
                System.out.println(coder[0]);
        }
    }
}
