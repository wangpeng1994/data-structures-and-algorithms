package com.github.wangpeng1994.datastructure.sparsearray;

public class SparseArray {

    public static void main(String[] args) {
        // 创建一个原始二维数组，如 11x11
        int[][] twoDArr = new int[11][11];
        twoDArr[1][2] = 1;
        twoDArr[2][3] = 2;
        twoDArr[3][0] = 1;

        for (int[] row : twoDArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        int[][] sparseArr = twoDArr2SparseArr(twoDArr);

        SparseArr2TwoDArr(sparseArr);
    }

    /**
     * 二维数组 转 稀疏数组
     *
     * @param twoDArr 原始二维数组
     * @return 转换后的稀疏数组
     */
    private static int[][] twoDArr2SparseArr(int[][] twoDArr) {
        int rows = twoDArr.length;
        int cols = twoDArr[0].length;

        // 1. 遍历二维数组得到非零数据的总数
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (twoDArr[i][j] != 0) {
                    sum++;
                }
            }
        }

        // 2. 创建相应稀疏数组并为第一行赋值
        int[][] sparseArr = new int[sum + 1][3];
        sparseArr[0][0] = rows;
        sparseArr[0][1] = cols;
        sparseArr[0][2] = sum;

        // 3. 再次遍历二维数组将有效数据填充到稀疏数组中
        int count = 0; // 用于记录有效数据在稀疏数组中应处的行数
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (twoDArr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = twoDArr[i][j];
                }
            }
        }

        // 输出稀疏数组
        for (int[] row : sparseArr) {
            System.out.printf("%d\t%d\t%d\n", row[0], row[1], row[2]);
        }

        return sparseArr;
    }

    /**
     * 稀疏数组 恢复到 原始二维数组
     *
     * @param sparseArr 稀疏数组
     * @return 原始二维数组
     */
    private static int[][] SparseArr2TwoDArr(int[][] sparseArr) {
        // 1. 读取稀疏数组第一行的数据，创建原始二维数组
        int[][] twoDArr = new int[sparseArr[0][0]][sparseArr[0][1]];

        // 2. 再读取稀疏数组其余行的数据，恢复原始二维数组
        for (int i = 1; i < sparseArr.length; i++) {
            twoDArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        // 输出恢复后的二维数组
        for (int[] row : twoDArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        return twoDArr;
    }
}
