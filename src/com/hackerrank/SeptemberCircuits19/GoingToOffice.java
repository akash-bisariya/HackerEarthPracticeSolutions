package com.hackerrank.SeptemberCircuits19;

import com.hackerrank.practices.DataStructure.IPracticeSolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoingToOffice implements IPracticeSolution {

    /**
     * https://www.hackerearth.com/challenges/competitive/september-circuits-19/algorithm/going-to-office-e2ef3feb/
     * @throws IOException
     */

    @Override
    public void startSolution() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long distance = Integer.parseInt(bufferedReader.readLine());

        String[] onlineTaxi = bufferedReader.readLine().split(" ");
        String[] classicTaxi = bufferedReader.readLine().split(" ");


        long onlineCost = calculateOnlineTaxiCost(onlineTaxi,distance);
        long classicCost = calculateClassicTaxiCost(classicTaxi,distance);

        if(onlineCost<classicCost || onlineCost==classicCost)
            System.out.println("Online Taxi");
        else
            System.out.println("Classic Taxi");




    }

    private static long calculateClassicTaxiCost(String[] classicTaxi, long distance) {

        long speed = Long.parseLong(classicTaxi[0]);
        long baseFare = Long.parseLong(classicTaxi[1]);
        long costForEveryMinute = Long.parseLong(classicTaxi[2]);
        long costForEachKms = Long.parseLong(classicTaxi[3]);

        return baseFare+(((long)distance/speed)*costForEveryMinute)+(distance*costForEachKms);

    }

    private static long calculateOnlineTaxiCost(String[] onlineTaxi,long distance) {

        long costForFirstKms = Long.parseLong(onlineTaxi[0]);
        long firstKms = Long.parseLong(onlineTaxi[1]);
        long costForOtherKms = Long.parseLong(onlineTaxi[2]);

        if(distance>costForFirstKms)
            return costForFirstKms+((distance-firstKms)*costForOtherKms);
        else
            return costForFirstKms;

    }
}
