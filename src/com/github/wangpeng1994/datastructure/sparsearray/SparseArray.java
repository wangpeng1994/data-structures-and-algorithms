package com.github.wangpeng1994.datastructure.sparsearray;

public class SparseArray {

    public static void main(String[] args) {
        // Create a original two-dimensional array sample.
        // 0: no chess piece  1: black piece  2: blue piece
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;

        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        // Transform two-dimensional array into sparse array.

        // 1. Loop through the two-dimensional array to get the count of nonzero data.
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }

        // 2. Create the corresponding sparse array.
        int[][] sparseArr = new int[sum + 1][3];
        // Assign values to this array.
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        // 3. Loop through the two-dimensional array again to assign nonzero data into the sparse array.
        int count = 0; // for record how many times met nonzero data
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        for (int[] row : sparseArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }


    }

}
