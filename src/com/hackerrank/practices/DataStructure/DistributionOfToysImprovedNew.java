package com.hackerrank.practices.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DistributionOfToysImprovedNew implements IPracticeSolution {
    @Override
    public void startSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        ArrayList<StringBuilder> finalArrayList = new ArrayList<>();
        int permutationCount = 0;
        for (int i = 0; i < testCases; i++) {
            int numOfToys = Integer.parseInt(br.readLine());
            int firstMax = numOfToys - 2;
            do {
                int remain = numOfToys - firstMax;

                for (int j = 1; j < remain; j++) {
                    StringBuilder temp = new StringBuilder();
                    int third = remain - j;
                    if (firstMax != j && firstMax != third) {
                        temp.append(firstMax).append(",");
                        temp.append(j).append(",");
                        temp.append(remain-j);

                        if(!checkIfPermutationExist(firstMax +","+ j +","+third,finalArrayList)){
                            System.out.println(firstMax+","+j+","+(remain-j));
                            finalArrayList.add(temp);
                            if(j - third == 0)
                                permutationCount = permutationCount+3;
                            else
                                permutationCount =permutationCount+6;

                        }

                    }
                }
                firstMax--;
            } while (firstMax >= (numOfToys / 3) + 1);
            System.out.println(permutationCount);
        }
    }

    private static boolean checkIfPermutationExist(String s, ArrayList arrayList) {
            String[] test = s.split(",");
            for (int i = 0; i < arrayList.size(); i++) {
                int count = 0;
                ArrayList<String> testArrayList = new ArrayList<>();
                testArrayList.add(arrayList.get(i).toString().split(",")[0]);
                testArrayList.add(arrayList.get(i).toString().split(",")[1]);
                testArrayList.add(arrayList.get(i).toString().split(",")[2]);

                for (String s1 : test) {
                    if (testArrayList.contains(s1))
                        count++;
                }

                if (count == 3)
                    return true;


            }
            return false;

    }
}
