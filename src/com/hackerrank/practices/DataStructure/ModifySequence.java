package com.hackerrank.practices.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ModifySequence implements IPracticeSolution{
    @Override
    public void startSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");

        for(int i=0;i<arr.length-1;i++){
            int firstNum= Integer.parseInt(arr[i]);
            int secondNum= Integer.parseInt(arr[i+1]);
            if(firstNum<secondNum){
                arr[i]="0";
                arr[i+1]=""+(secondNum-firstNum);
            }
            else{
                arr[i+1]="0";
                arr[i]=""+(secondNum-firstNum);
            }

        }
        boolean ifAllZero =false;
        for(int i=0;i<arr.length;i++){
            ifAllZero = arr[i].equals("0");
        }

        if(ifAllZero)
            System.out.print("YES");
        else
            System.out.print("NO");
    }
}
