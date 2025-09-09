package strings.easy;

//Problem link = https://leetcode.com/problems/search-a-2d-matrix-ii/description/
public class Leetcode_240 {

    //Approach - https://takeuforward.org/arrays/search-in-a-row-and-column-wise-sorted-matrix/
    //TC - O(m+n)
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int column = matrix.length-1;

        while (row <= matrix.length - 1 && column >= 0) {
            if (matrix[row][column] == target) {
                return true;
            } else if (matrix[row][column] > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        /*System.out.println(searchMatrix(new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        }, 5));*/

        String s = "the sky is blue";
        //String s = "  hello world  ";
        //String s = "a good   example";
        String trimString = s.trim();
        String[] s1 = new String[trimString.length()];
        for (int i = 0; i < trimString.length(); i++) {
            if (i > 0 && (s1[i-1].equalsIgnoreCase(" ") || s1[i-1].equalsIgnoreCase("-1"))
                    && trimString.charAt(i) == ' ') {
                s1[i] = "-1";
            } else {
                s1[i] = String.valueOf(trimString.charAt(i));
            }
        }

        StringBuilder res = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (int i = trimString.length() - 1; i >= 0; i--) {
            if (s1[i].equalsIgnoreCase(" ")) {
                res.append(sb.reverse());
                res.append(s1[i]);
                sb.delete(0, sb.length());
            } else if (s1[i].equalsIgnoreCase("-1")){
                continue;
            } else {
                sb.append(s1[i]);
            }
        }
        res.append(sb.reverse());
        System.out.println(res.toString());
    }
}
