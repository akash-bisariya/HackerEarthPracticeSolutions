package com.hackerrank.practices.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DistributionOfToys implements IPracticeSolution {


    @Override
    public void startSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCases; i++) {
            int numOfToys = Integer.parseInt(br.readLine());
            ArrayList<StringBuilder> arrayList = new ArrayList<>();
            int limit = 0;
            if (numOfToys % 2 == 0)
                limit = numOfToys / 2 - 1;
            else
                limit = numOfToys / 2;
            for (int j = numOfToys - 2; j >= limit; j--) {
                int remain = numOfToys - j;
                for (int k = 1; k < remain; k++) {
                    StringBuilder com = new StringBuilder(3);
                    com.append(j).append(",");
                    com.append(k).append(",");
                    com.append(remain - k);
                    if (!checkIfTwoWinner(com, j)) {
                        arrayList.add(com);
                    }
                }
            }
            checkIfPermutationExist(arrayList);
            System.out.println(countPermutation(arrayList));
        }


    }

    private int countPermutation(ArrayList<StringBuilder> arrayList) {
        int count = 0;
        for (StringBuilder stringBuilder : arrayList) {
            System.out.println(stringBuilder);
            if (!checkIfUnique(stringBuilder.toString().split(",")))
                count = count + 3;
            else
                count = count + 6;
        }
        return count;
    }

    private boolean areAnagram(StringBuilder string1, StringBuilder string2) {
        String[] str1 = string1.toString().split(",");
        String[] str2 = string2.toString().split(",");
        int found = 0, not_found = 0;
        for (int i = 0; i < 3; i++) {
            found = 0;
            for (int j = 0; j < 3; j++) {
                if (str1[i].equals(str2[j])) {
                    found = 1;
                    break;
                }
            }
            if (found == 0) {
                not_found = 1;
                break;
            }
        }
        return not_found != 1;
    }

    private void checkIfPermutationExist(ArrayList<StringBuilder> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = i + 1; j < arrayList.size(); j++) {
                if (areAnagram(arrayList.get(i), arrayList.get(j))) {
                    arrayList.remove(i);
                    i--;
                }
            }
        }

    }

    private static boolean checkIfUnique(String[] com) {
        for (int i = 0; i < com.length; i++) {
            for (int j = i + 1; j < com.length; j++) {
                if (com[i].equals(com[j]))
                    return false;
            }
        }
        return true;
    }

    private static boolean checkIfTwoWinner(StringBuilder com, int max) {
        for (int i = 1; i < com.length(); i++) {
            if ((com.charAt(i) - '0') == max)
                return true;
        }
        return false;
    }


}
