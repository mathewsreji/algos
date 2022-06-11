package com.reji.recursion;

import java.util.Arrays;

public class PictureRotation {
    static int[][] matrix = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
    /*
    5,  1,  9,  11
    2,  4,  8,  10
    13, 3,  6,  7
    15, 14, 12, 16
    */

    /*
    [0,0], [0,1], [0,2], [0,3]

    [1,0], [1,1], [1,2], [1,3]

    [2,0], [2,1], [2,2], [2,3]

    [3,0], [3,1], [3,2], [3,3]
    */



    public static void main(String[] args) {
        rotate(matrix, matrix.length);
    }

    public static void rotate(int[][] data, int size) {

        if(data.length == 1) {
            return;
        }

        int temp = 0;// xPos = 0, yPos = 0;
        for(int offset = 0; offset < size-1; offset++) {

            temp = matrix[0][offset]; //top left corner

            matrix[0][offset] = matrix[size-1-offset][0]; // bottom left corner

            matrix[size-1-offset][0] = matrix[size-1][size - 1 - offset]; // bottom right corner

            matrix[size-1][size - 1 - offset] = matrix[offset][size - 1]; // top right corner

            matrix[offset][size - 1] = temp;
        }

        printArray(matrix);

    }

    private static void printArray(int[][] array) {
       for(int i = 0; i < array.length ; i++) {
           System.out.print("\n");
           for(int j = 0; j < array.length ; j++) {
               System.out.print(array[i][j] + " ");
           }
       }
    }
}
