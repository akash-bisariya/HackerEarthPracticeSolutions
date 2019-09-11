package com.hackerrank.practices.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ConstructingBuildings implements IPracticeSolution {
    @Override
    public void startSolution() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfPeople = Integer.parseInt(bufferedReader.readLine());
        ArrayList<String> arrayList = new ArrayList<>();
        for (int l = 0; l < numberOfPeople; l++) {
            arrayList.add(bufferedReader.readLine());
        }
        int count = 0;
        int flagCount=0;
        ArrayList<String> flagList= new ArrayList<>();
        String firstString = arrayList.get(0);
        for (int i = 0; i < firstString.length(); i++) {
            for (int j = i + 1; j <= firstString.length(); j++) {
                String flag = firstString.substring(i, j);
                if (IsPalindrome(flag) || flag.length() == 1) {
                    for (int p = 1; p < arrayList.size(); p++) {
                        boolean allMatched = false;
                        if(!flagList.contains(flag)){
                            flagList.add(flag);
                            flagCount++;
                        }
                        int index = arrayList.get(p).indexOf(flag);
                        if(index>0){
                        while(index>=0) {
                            index = arrayList.get(p).indexOf(flag,index+1);
                            count++;
                        }
                        }
                    }
                }
            }
        }

        int waysToChoseFlag= ((flagCount*(flagCount+1))/2)*((flagCount*(flagCount+1))/2);

        float modinv = modInverse(waysToChoseFlag,100000007);

        System.out.println((modInverse(waysToChoseFlag,1000000007)*count)%1000000007);

    }

    private static boolean IsPalindrome(String flag) {
        StringBuilder reverse = new StringBuilder();
        for (int i = flag.length() - 1; i >= 0; i--) {
            reverse.append(flag.charAt(i));
        }
        return flag.equals(reverse.toString());
    }

    private static int modInverse(int a, int m)
    {
        a = a % m;
        for (int x = 1; x < m; x++)
            if ((a * x) % m == 1)
                return x;
        return 1;
    }

}
