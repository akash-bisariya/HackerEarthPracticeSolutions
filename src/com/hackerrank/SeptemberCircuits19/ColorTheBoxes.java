package com.hackerrank.SeptemberCircuits19;

import com.hackerrank.practices.DataStructure.IPracticeSolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ColorTheBoxes implements IPracticeSolution {

    @Override
    public void startSolution() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        System.out.println(getProduct(Integer.parseInt(input[1])));

    }

    private static long getProduct(int color) {
        long product = 1;
        while (color > 0) {
            product = ((product % 1000000007) * (color % 1000000007)) % 1000000007;
            color--;
        }
        return product;
    }


}
