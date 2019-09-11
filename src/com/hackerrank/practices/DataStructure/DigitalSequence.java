package com.hackerrank.practices.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DigitalSequence implements IPracticeSolution {

    /**
     * Problem Link - https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/digitial-sequence-ee0ea080/
     * @throws IOException
     */
    @Override
    public void startSolution() throws IOException {
        BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        String[] arr = bufferedReader.readLine().split(" ");
        int prevCount=1;
        int count =1;

        for(int i=0;i<arr.length;i++){
            String first = arr[i];
            ArrayList<Integer> digits  = getDigits(first);
            for(int j=i+1;j<arr.length;j++){
                ArrayList<Integer> temp = getDigits(arr[j]);
                for(int k=0;k<temp.size();k++){
                    if(digits.contains(temp.get(k))){
                        count++;
                        prevCount=count;
                        break;
                    }
                    else
                        count=0;
                }
            }

        }
        System.out.println(prevCount);
    }

    private static ArrayList<Integer> getDigits(String first) {
        int num = Integer.parseInt(first);
        ArrayList<Integer> arrayList = new ArrayList<>();
        while(num>0){
            arrayList.add(num%10);
            num= num/10;
        }
        return arrayList;
    }
}
