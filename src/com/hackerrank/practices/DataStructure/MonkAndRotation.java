package com.hackerrank.practices.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MonkAndRotation implements IPracticeSolution {
    @Override
    public void startSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcases = Integer.parseInt(br.readLine());
        for(int i=0;i<testcases;i++){
            String[] input = (br.readLine().split(" "));
            int size = Integer.parseInt(input[0]);
            int rotation = Integer.parseInt(input[1]);
            String[] arr = (br.readLine().split(" "));

            rotation = rotation%size;
            for(int j=0;j<rotation;j++){
                rotateRightByOne(arr);
            }
            for(int k=0;k<arr.length;k++)
            System.out.print(arr[k]+" ");
            System.out.println("");

        }

    }

    private void rotateRightByOne(String[] array) {
        String last = array[array.length-1];
        for(int i=array.length-1;i>0;i--){
            array[i] = array[i-1];
        }
        array[0] = last;
    }
}
