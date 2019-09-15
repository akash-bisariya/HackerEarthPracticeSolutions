package com.hackerrank.practices;

import com.hackerrank.practices.DataStructure.IPracticeSolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class XORRanges implements IPracticeSolution {


    @Override
    public void startSolution() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int test  = Integer.parseInt(bufferedReader.readLine());

        ArrayList<Integer> array = new ArrayList<>();
        for(int i=0;i<test;i++){
            String[] query = bufferedReader.readLine().split(" ");

            switch (Integer.parseInt(query[0])){


                case 1:{
                    array.add(0,Integer.parseInt(query[1]));

                }
                break;

                case 2:{
                    array.add(Integer.parseInt(query[1]));
                }
                break;

                case 3:{
                    int l = Integer.parseInt(query[1]);
                    int r = Integer.parseInt(query[2]);

                    int xorvalue=array.get(l-1);

                    for(int j=l;j<r;j++){
                        xorvalue = xorvalue^array.get(j);
                    }

                    System.out.println(xorvalue);
                }

                break;

            }

        }





    }
}
