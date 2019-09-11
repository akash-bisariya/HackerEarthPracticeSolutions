package com.hackerrank.practices.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DistributionOfToysImproved implements IPracticeSolution {
    @Override
    public void startSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        int permutationCount=0;
        ArrayList<StringBuilder> finalArrayList = new ArrayList<>();
        for (int i = 0; i < testCases; i++) {
            int numOfToys = Integer.parseInt(br.readLine());
            int firstMax = numOfToys-2;
            do{
                ArrayList<Integer> arrayList = new ArrayList<>();

                int remain = numOfToys-firstMax;
                for(int j=1;j<remain;j++){
                    StringBuilder temp = new StringBuilder();
                    arrayList.add(firstMax);
                    if(!arrayList.contains(j)) {
                        if(firstMax!=j && firstMax!=remain-j && !checkIfPermutationExist(""+firstMax+","+j+","+(remain-j),finalArrayList)){
                            arrayList.add(j);
                            arrayList.add(remain - j);
                            temp.append(firstMax).append(",");
                            temp.append(j).append(",");
                            temp.append(remain-j);
                            finalArrayList.add(temp);
//                            System.out.println(temp);
                        }

                    }
                }
                firstMax--;
            }while(firstMax>=(numOfToys/3)+1);
        }

        System.out.println(countPermutation(finalArrayList));
    }


    private static int countPermutation(ArrayList<StringBuilder> arrayList) {
        int count = 0;
        for (StringBuilder stringBuilder : arrayList) {
            if (!checkIfUnique(stringBuilder.toString().split(",")))
                count = count + 3;
            else
                count = count + 6;
        }
        return count;
    }


    private static boolean checkIfUnique(String[] com) {
        String prev="";
        for (int i = 0; i < com.length; i++) {
           if(com[i].equals(prev)){
               return false;
           }
           else
               prev = com[i];
        }
        return true;
    }



    private static boolean checkIfPermutationExist(String s, ArrayList arrayList) {
        if(!checkIf2Max(s)) {
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
        else
            return true;

    }




    private static boolean checkIf2Max(String s) {
        String[] array = s.split(",");
        String max = array[0];
        for(String s1:array){
            if(Integer.parseInt(max)<Integer.parseInt(s1)){
                max=s1;
            }
        }
        int count=0;
        for(int i=0;i<array.length;i++){
            if(max.equals(array[i]))
                count++;
        }
        return count > 1;
    }

    private static ArrayList<String> getPermuatation(String str){

//        if(str.length() == 0) {
//            //return array list with 1 index as empty string
//            ArrayList<String> baseRes = new ArrayList<>();
//            baseRes.add("");
//            return baseRes;
//        }

        char cc = str.charAt(0); //get first char;
        String ros = str.substring(1); //rest of the string
        ArrayList<String> finalRes = new ArrayList<>();
        ArrayList<String> recRes = getPermuatation(ros); //rec on substring;
        for(int i = 0; i<recRes.size(); i++) {
            String recString = recRes.get(i);
            for(int j = 0; j<=recString.length(); j++) {
                String combi = recString.substring(0, j) + cc + recString.substring(j);
                finalRes.add(combi);
            }
        }

        return finalRes;

    }
}
