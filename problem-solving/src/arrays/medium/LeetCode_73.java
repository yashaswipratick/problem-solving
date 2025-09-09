package arrays.medium;

// Problem link - https://leetcode.com/problems/set-matrix-zeroes/description/
// Reference - https://www.youtube.com/watch?v=dSxt3ZCbIqA
public class LeetCode_73 {



    /*
    1. Use first row and first column as markers:
        Instead of creating extra arrays to track which rows and columns should be zeroed, we cleverly reuse the first row and first column of the matrix to store this information.

    2. Scan the entire matrix:

             If any cell is 0, do two things:

                Mark the first cell of that row as 0

                Mark the first cell of that column as 0

     This tells us: "Hey, this whole row or column should become zero later."

     3. Also, keep two flags:

        firstRow = true if the first row contains a zero

        firstColumn = true if the first column contains a zero

     4. Go through the rest of the matrix (excluding first row and column):

        If the row marker or column marker (in first row or column) is 0, set the current cell to 0.

     5. Finally handle the first row and first column separately:

     If we had a zero in the first row initially, set entire first row to 0.

        If we had a zero in the first column initially, set entire first column to 0.
     */

    public static void setZeroes(int[][] matrix) {
        boolean firstRow = false;
        boolean firstColumn = false;

        //set markers in first row and first column
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) firstRow = true;
                    if (j == 0) firstColumn = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //Replace inner matrix

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        //if first row has zero then mark all the element in first column as zero
        if (firstRow) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        //if first column has zero then mark all the element in first row as zero
        if (firstColumn) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
