package com.hackerrank.practices.DataStructure;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MovingPeople implements IPracticeSolution {

    /**
     * Link - https://www.hackerearth.com/challenges/competitive/august-circuits-19/algorithm/mind-flayer-returns-68bb7306/
     * <p>
     * Updated problem name
     * <p>
     * Moving people
     * <p>
     * Updated problem statement
     * <p>
     * The people of your city are living in a  NxM  grid. If a person is out of the grid after multiple instructions,
     * then that person is not counted in further steps.
     * <p>
     * Initially, there is at most one person in every cell of this grid. You can perform Q operations or query of the following types:
     * <p>
     * 1 X Y: Move every person that is currently residing in the grid, X column left of their cells and Y column above of their cells.
     * If X is negetive, then move people abs(X) column right of their cells. Also, if Y is negative,then move people  column down of their cells.
     * 2 : Calculate the numbner of people that are currently living in the grid.
     * Input format
     * <p>
     * First line: Three integers N, M & Q  denoting the number of rows that are available in the grid,
     * number of columns that are available in the grid, and number of instructions
     * Next N lines: A string  consisting of only 0 & 1. In the ith string, the jth character is 1 if there is a person in that cell,
     * otherwise there will be 0
     * Next Q lines: One of the 2 types of operations as stated above.
     * Output format
     * For each 2nd type of query, print the number of persons that are available in the grid at the time of that query.
     * <p>
     * Constraints
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * 4 4 6
     * 1111
     * 0101
     * 1100
     * 1010
     * 1 4 0
     * 0000
     * 0000
     * 0000
     * 0000
     * 1 3 0
     * 1000
     * 1000
     * 0000
     * 0000
     * 1 2 0
     * 0000
     * 0000
     * 0000
     * 0000
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * SAMPLE INPUT
     * 4 4 6
     * 1111
     * 0001
     * 1101
     * 0011
     * <p>
     * 2
     * 1 0 -2
     * 1 1 0
     * 2
     * 1 -2 1
     * 2
     * SAMPLE OUTPUT
     * 10
     * 4
     * 2
     */

    @Override
    public void startSolution() throws IOException {

        FastReader fr = new FastReader();
        PrintWriter op = new PrintWriter(System.out);

        int n = fr.nextInt(), m = fr.nextInt(), q = fr.nextInt(), grd[][] = new int[n][m + 1], i, j, ptr[][] = new int[4][2];

        for (i = 0; i < n; ++i) {
            String s = " " + fr.next();
            grd[i][0] = 0;
            for (j = 1; j <= m; ++j)
                grd[i][j] = grd[i][j - 1] + s.charAt(j) - 48;
        }
        ptr[0][0] = 0;
        ptr[2][0] = 1;
        ptr[3][0] = m;
        ptr[1][0] = n - 1;//u,b,l,r
        ptr[0][1] = ptr[1][1] = ptr[2][1] = ptr[3][1] = 0;

        while (q-- > 0) {
            if (fr.nextInt() == 2) {
                int ans = 0;
                for (i = ptr[0][0]; i <= ptr[1][0]; ++i) {
                    if (ptr[2][0] <= ptr[3][0]) ans += (grd[i][ptr[3][0]] - grd[i][ptr[2][0] - 1]);
                }
                op.println(ans);
            } else {
                i = fr.nextInt();
                j = fr.nextInt();
                int k;

                if (i >= 0) {
                    ptr[3][1] += i;
                    k = Math.min(i, ptr[2][1]);
                    i -= k;
                    ptr[2][1] -= k;
                    ptr[2][0] += i;
                } else {
                    ptr[2][1] -= i;
                    k = Math.min(-i, ptr[3][1]);
                    i += k;
                    ptr[3][1] -= k;
                    ptr[3][0] += i;
                }
                if (j >= 0) {
                    ptr[1][1] += j;
                    k = Math.min(j, ptr[0][1]);
                    j -= k;
                    ptr[0][1] -= k;
                    ptr[0][0] += j;
                } else {
                    ptr[0][1] -= j;
                    k = Math.min(-j, ptr[1][1]);
                    j += k;
                    ptr[1][1] -= k;
                    ptr[1][0] += j;
                }
            }
        }
        op.flush();
        op.close();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || (!st.hasMoreElements())) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            return st.nextToken();
        }

        String nextLine() {
            String str = "";

            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return str;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }


//
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String[] sizeAndQuery = bufferedReader.readLine().split(" ");
//        int row = Integer.parseInt(sizeAndQuery[0]);
//        int column = Integer.parseInt(sizeAndQuery[1]);
//
//        int[][] grid = new int[row][column];
//        for (int i = 0; i < row; i++) {
//            String firstRow = bufferedReader.readLine();
//            int[] arr = new int[firstRow.length()];
//            for (int j = 0; j < firstRow.length(); j++) {
//                arr[j] = firstRow.charAt(j) - '0';
//            }
//            grid[i] = arr;
//        }

//        for (int k = 0; k < Integer.parseInt(sizeAndQuery[2]); k++) {
//            String[] query = bufferedReader.readLine().split(" ");
//            if (query[0].equals("2")) {
//                int count = 0;
//                for (int l = 0; l < row; l++) {
//                    for (int m = 0; m < column; m++) {
//                        if (grid[l][m] == 1) {
//                            count++;
//                        }
//                    }
//                }
//                System.out.println(count);
//
//            } else if (query[0].equals("1")) {
//                int x = Integer.parseInt(query[1]);
//                int y = Integer.parseInt(query[2]);
//                int[][] temp = new int[row][column];
//
//
//                if (x < 0 && Math.abs(x) < column) {
//                    for (int l = 0; l < row; l++)
//                        System.arraycopy(grid[l], 0, temp[l], Math.abs(x) % column, column - (Math.abs(x % column)));
//                    grid = temp;
//                }
//
//                else if (x > 0 && x < column) {
//                    for (int l = 0; l < row; l++){
//                        int length = column - (Math.abs(x) % column);
////                        if(length>=4)
////                            length--;
//                        int pos =Math.abs(x) % column;
////                        if(pos>=4)
////                            pos--;
//                        System.arraycopy(grid[l], pos, temp[l], 0, length);
//                    }
//                    grid = temp;
//                }
//
//                if (y < 0 && Math.abs(y) < row) {
//                    for (int l = 0; l < row; l++) {
//                        if (l + Math.abs(y) < row) {
//                            int[] arr = grid[l];
//                            temp[l + Math.abs(y)] = arr;
//                        }
//
//                    }
//                    grid = temp;
//                }
//
//                else if (y > 0 && Math.abs(y) < row) {
//                    for (int l = 0; l < row; l++) {
//                        if (l - Math.abs(y) >= 0) {
//                            int[] arr = grid[l];
//                            temp[l - Math.abs(y)] = arr;
//                        }
//                    }
//                    grid = temp;
//                }
//
//                if(Math.abs(x)>=4 || Math.abs(y)>=4)
//                    grid = temp;
//
//                showGrid(grid, row, column);
//            }
//        }

}

//    private static void showGrid(int[][] grid, int row, int column) {
//        for (int l = 0; l < row; l++) {
//            for (int m = 0; m < column; m++) {
//                System.out.print(grid[l][m]);
//            }
//            System.out.println();
//        }
//    }
//}
