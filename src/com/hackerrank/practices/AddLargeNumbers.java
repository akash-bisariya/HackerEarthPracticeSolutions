package com.hackerrank.practices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddLargeNumbers {
    /**
     * Adding very large numbers using strings
     */

    public static void startSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder firstNum = new StringBuilder(br.readLine());
        StringBuilder secondNum = new StringBuilder(br.readLine());
        if(firstNum.length()>secondNum.length())
            System.out.println(addNumbers(firstNum.reverse(),secondNum.reverse()));
        else
            System.out.println(addNumbers(secondNum.reverse(),firstNum.reverse()));
    }

    private static StringBuilder addNumbers(StringBuilder firstNum, StringBuilder secondNum) {
        StringBuilder sumString= new StringBuilder();
        int savedCarry=0;
        for(int i=0;i<secondNum.length();i++){
            int actualSum  = Integer.parseInt(String.valueOf(firstNum.charAt(i)))+Integer.parseInt(String.valueOf(secondNum.charAt(i)))+savedCarry;
            int savedSum = actualSum%10;
            savedCarry = actualSum/10;
            sumString.append(savedSum);
        }

        for(int j=secondNum.length();j<=firstNum.length()-1;j++){
            int actualSum  = Integer.parseInt(String.valueOf(firstNum.charAt(j)))+savedCarry;
            int savedSum = actualSum%10;
            savedCarry = actualSum/10;
            sumString.append(savedSum);
        }

        if(savedCarry>0){
            sumString.append(savedCarry);
        }

        return sumString.reverse();
    }
}
