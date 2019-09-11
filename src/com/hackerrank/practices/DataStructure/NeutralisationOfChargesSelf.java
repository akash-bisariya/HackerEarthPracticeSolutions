package com.hackerrank.practices.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NeutralisationOfChargesSelf {
    /**
     * In a parallel universe, there are not just two charges like positive and negative,
     * but there are 26 charges represented by lower  english alphabets.
     * <p>
     * Charges have a property of killing each other or in other words neutralizing each other
     * if they are of same charge and next to each other.
     * <p>
     * You are given a string s where each si represents a charge, where 0<=i<=|s|-1.
     * <p>
     * You need to output size of final string followed by string after which no neutralizing is possible.
     * <p>
     * SAMPLE INPUT
     * 12
     * aaacccbbcccd
     * SAMPLE OUTPUT
     * 2
     * ad
     * Explanation
     * aaacccbbcccd -> accd -> ad
     */

    public static void startSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine()); //size
        String arr = br.readLine();
        StringBuilder arrCopy = new StringBuilder(arr);
        StringBuilder str = getNeutralString(arrCopy);
        System.out.println(str.length());
        System.out.println(str);
    }

    private static boolean checkWeatherNeedNeutralization(StringBuilder str) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1))
                return true;
        }
        return false;
    }

    private static StringBuilder getNeutralString(StringBuilder arrCopy) {
        StringBuilder output = new StringBuilder("");
        for (int i = 0; i <= arrCopy.length() - 1; ) {
            if (i + 1 == arrCopy.length()) {
                output.append(arrCopy.charAt(i));
                i++;
            } else {
                if (arrCopy.charAt(i) == arrCopy.charAt(i + 1)) {
                    i = i + 2;
                } else {
                    output.append(arrCopy.charAt(i));
                    i++;
                }
            }
        }
        if (checkWeatherNeedNeutralization(output))
            return getNeutralString(output);
        return output;
    }
}
