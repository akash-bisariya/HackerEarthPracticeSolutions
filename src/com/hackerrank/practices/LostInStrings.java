package com.hackerrank.practices;

import com.hackerrank.practices.DataStructure.IPracticeSolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LostInStrings implements IPracticeSolution {
    @Override
    public void startSolution() throws IOException {

        ArrayList<String> listOfString = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        listOfString.add(bufferedReader.readLine());
        int queries = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < queries; i++) {

            String[] query = bufferedReader.readLine().split(" ");

            switch (Integer.parseInt(query[0])) {

                case 1: {
                    int length = Integer.parseInt(query[1]);
                    int nth = Integer.parseInt(query[2]);
                    String charTobeAdded = query[3];
                    listOfString.add(listOfString.get(nth - 1).substring(0, length - 1) + charTobeAdded);

                }
                break;

                case 2: {
                    int length = Integer.parseInt(query[1]);
                    int nth = Integer.parseInt(query[2]);
                    listOfString.add(listOfString.get(nth - 1).substring(0, length));
                }
                break;

                case 3: {
                    int l = Integer.parseInt(query[1]);
                    int r = Integer.parseInt(query[2]);
                    boolean isFound = false;
                    String s = query[3];
                    for (int j = 0; j < listOfString.size(); j++) {
                        if (listOfString.get(j).length()>=s.length() && listOfString.get(j).substring(0, s.length()).equals(s)) {
                            System.out.println("yes");
                            isFound = true;
                            break;
                        }
                    }
                    if(!isFound)
                    System.out.println("no");
                    break;


                }

            }
        }

    }
}
