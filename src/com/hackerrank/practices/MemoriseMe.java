package com.hackerrank.practices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MemoriseMe {

    /**
     * Arijit is a brilliant boy. He likes memory games. He likes to participate alone but this time he has to have a partner. So he chooses you.
     * <p>
     * In this Game , your team will be shown N numbers for few minutes . You will have to memorize these numbers.
     * <p>
     * Now, the questioner will ask you Q queries, in each query He will give you a number , and you have to tell him the total number of occurrences of that number in the array of numbers shown to your team . If the number is not present , then you will have to say “NOT PRESENT” (without quotes).
     * <p>
     * INPUT And OUTPUT
     * <p>
     * The first line of input will contain N, an integer, which is the total number of numbers shown to your team.
     * <p>
     * The second line of input contains N space separated integers .
     * <p>
     * The third line of input contains an integer Q , denoting the total number of integers.
     * <p>
     * The Next Q lines will contain an integer denoting an integer,  , for which you have to print the number of occurrences of that number () in those N numbers on a new line.
     * <p>
     * If the number  isn’t present then Print “NOT PRESENT” (without quotes) on a new line.
     * <p>
     * SAMPLE INPUT
     * 6
     * 1 1 1 2 2 0
     * 6
     * 1
     * 2
     * 1
     * 0
     * 3
     * 4
     * SAMPLE OUTPUT
     * 3
     * 2
     * 3
     * 1
     * NOT PRESENT
     * NOT PRESENT
     */

    public static void takeInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array");
        int size = sc.nextInt();
        System.out.println("Enter elements of array");
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = sc.nextInt();

        takeFindArrayInput(arr);


    }

    public static void takeFindArrayInput(int[] arr) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array to find");
        int size = Integer.parseInt(sc.nextLine());
        System.out.println("Enter elements of array");
        int[] arrToFind = new int[size];
        for (int i = 0; i < size; i++) {
            if(sc.hasNextInt())
            arrToFind[i] = sc.nextInt();
        }
        for (int i = 0; i < size; i++)
        findOccurences(arrToFind[i],arr);


    }

    public static void findOccurences(int num, int[] arr){
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (num == arr[i])
                count++;
        }
        if (count > 0)
            System.out.println(count);
        else
            System.out.println("NOT PRESENT");
    }


    public static void acceptedSolution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] indexedArray = new int[100000];

        String[] arr = new String[ Integer.parseInt(reader.readLine())];;

        arr = reader.readLine().split(" ");


        for(int i=0;i<arr.length;i++){
            int index = Integer.parseInt(arr[i]);
            indexedArray[index]++;
        }

        int[] arrToFind = new int[Integer.parseInt(reader.readLine().trim())];

        for (int i = 0; i < arrToFind.length; i++) {

            int num = Integer.parseInt(reader.readLine().trim());
            int count = indexedArray[num];

            if (count != 0)
                System.out.println(count);
            else
                System.out.println("NOT PRESENT");

        }
    }

}
