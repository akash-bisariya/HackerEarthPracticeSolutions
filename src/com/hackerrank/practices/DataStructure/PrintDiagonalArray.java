package com.hackerrank.practices.DataStructure;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalArray implements IPracticeSolution {
    @Override
    public void startSolution() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int[][] arr = new int[row][col];

//        int[][] arr = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9},
//                {10, 11, 12}};
//

        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        int[] printArray = findDiagonalOrder(arr);
        System.out.println(Arrays.toString(printArray));
    }

    private int[] findDiagonalOrder(int[][] matrix) {
        int row = matrix.length;
        int col=0;
        if(row>0) {
            col = matrix[0].length;
        }
        int[] diagonalArray = new int[row * col];

        if(row>0 && col>0) {
            int index = 0;
            for (int i = 0; i < (row + col - 1); i++) {
                if (i % 2 == 0) {
                    for (int j = row - 1; j >= 0; j--) {
                        for (int k = col - 1; k >= 0; k--) {
                            if (j + k == i) {
                                diagonalArray[index] = matrix[j][k];
                                index++;
                            }
                        }
                    }
                } else {
                    for (int j = 0; j < row; j++) {
                        for (int k = 0; k < col; k++) {
                            if (j + k == i) {
                                diagonalArray[index] = matrix[j][k];
                                index++;
                            }
                        }
                    }
                }
            }
        }
        return diagonalArray;
    }
}
