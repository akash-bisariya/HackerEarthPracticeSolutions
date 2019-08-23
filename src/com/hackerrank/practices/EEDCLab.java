package com.hackerrank.practices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EEDCLab {
    /**
     * Problem Link - https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/eedc/
     * <p>
     * You must be tired using the Function Generator and the CRO during the EEDC Lab. But the Midsem Lab Test is yet to come.
     * You have to prepare for it and perform all the experiments in order to know the working of those machines.
     * <p>
     * You decide to go to the lab and try those experiments but the lab is locked.
     * The key is with the CC3 guard and he will give you the key only if you answer his queries.
     * <p>
     * The guard loves the numbers divisible by 2,3 and 5.
     * <p>
     * Lucky indices are those index for which the sum of numbers formed using the array elements on its left and
     * array elements on its right is divisible by 2,3 and 5.
     * For example:- Consider the array [1,2,3,4,5] and index 3 (1 - based). The number formed using the array
     * elements on the left is 12 and the number formed using the array elements on the right is 45.
     * <p>
     * So he gives you an array of integers and asks you Q queries. In each query he provides you two integers L and R.
     * You have to answer how many lucky indices are there between L to R (both inclusive).
     * <p>
     * See sample for more clarity.
     * <p>
     * Input Format:
     * <p>
     * First line contains an integer N, which denotes the length of the array A.
     * Second line contains N space-separated integers.
     * Next line contains number of queries Q.
     * Next Q lines contain two integers L and R.
     * <p>
     * Output Format
     * <p>
     * For each query, print the number of lucky indices present in that range.
     * <p>
     * Constraints
     * <p>
     * 1 ≤  ≤ 6
     * <p>
     * <p>
     * Problem Setter - Harsh Jain
     * <p>
     * SAMPLE INPUT
     * 7
     * 1 5 7 5 6 7 5
     * 5
     * 1 2
     * 2 3
     * 4 6
     * 1 7
     * 3 6
     * SAMPLE OUTPUT
     * 0
     * 0
     * 1
     * 1
     * 1
     * Explanation
     * For
     * Index 1: Left Number: 0 and Right Number: 575675
     * Index 2: Left Number: 1 and Right Number: 75675
     * Index 3: Left Number: 15 and Right Number: 5675
     * Index 4: Left Number: 157  and Right Number: 675
     * Index 5: Left Number: 1575 and Right Number: 75
     * Index 6: Left Number: 15756 and Right Number: 5
     * Index 7: Left Number: 157567 and Right Number: 0
     * Only sum of numbers at index 5 is divisible by 2,3 and 5
     */

    public static void startSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        StringBuilder totalsum;

        int[] tempArray = new int[size];
        for(int i=0;i<tempArray.length;i++){
            int count=0;
            StringBuilder leftNum = getLeftNumber(arr, i).reverse();
            StringBuilder rightNum =  getRightNumber(arr, i).reverse();
            if(leftNum.length()>rightNum.length())
                totalsum = addNumbers(leftNum,rightNum);
            else
                totalsum = addNumbers(rightNum,leftNum);

            if ((totalsum.charAt(totalsum.length()-1)-'0')%2==0 && checkIfDivBy3(totalsum) && (totalsum.charAt(totalsum.length()-1)-'0'==5 || totalsum.charAt(totalsum.length()-1)-'0'==0) ) {
                count++;
            }
            tempArray[i]=count;
        }


        int queries = Integer.parseInt(br.readLine());

        for (int i = 0; i < queries; i++) {
            String[] qr = br.readLine().split(" ");
            int l = Integer.parseInt(qr[0]) - 1;
            int r = Integer.parseInt(qr[1]) - 1;
            int count=0;
            while (l <= r) {
                if (tempArray[l]==1) {
                    count++;
                }
                l++;
            }
            System.out.println(count);
        }
    }


    private static boolean checkIfDivBy3(StringBuilder totalSum) {
        long sumOfDigit=0;
        for(int i=0;i<totalSum.length();i++){
            sumOfDigit =sumOfDigit + totalSum.charAt(i)-'0';
        }
        return sumOfDigit % 3 == 0;
    }

    private static StringBuilder getLeftNumber(String[] arr, int l) {
        StringBuilder num = new StringBuilder();
        if (l == 0)
            return new StringBuilder("0");
        else {
            for (int i = 0; i < l; i++) {
                num.append(arr[i]);
            }
        }
        return num;
    }

    private static StringBuilder getRightNumber(String[] arr, int l) {
        StringBuilder num = new StringBuilder();
        if (l >= arr.length-1)
            return new StringBuilder("0");
        else {
            for (int i = l + 1; i < arr.length; i++) {
                num.append(arr[i]);
            }
        }
        return num;
    }

    private static StringBuilder addNumbers(StringBuilder firstNum, StringBuilder secondNum) {
        StringBuilder sumString= new StringBuilder();
        int savedCarry=0;
        for(int i=0;i<secondNum.length();i++){
            int actualSum  = (firstNum.charAt(i)-'0')+(secondNum.charAt(i)-'0')+savedCarry;
            int savedSum = actualSum%10;
            savedCarry = actualSum/10;
            sumString.append(savedSum);
        }

        for(int j=secondNum.length();j<=firstNum.length()-1;j++){
            int actualSum  = (firstNum.charAt(j)-'0')+savedCarry;
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
