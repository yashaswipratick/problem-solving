package arrays.easy;

import java.util.ArrayList;
import java.util.List;

//Problem description - https://leetcode.com/problems/pascals-triangle/description/
//Ref - https://www.youtube.com/watch?v=bR7mQgwQ_o8
public class Leetcode_118 {

    /*
        Approach to generate Pascal's Triangle:

        1. We need to generate Pascal's Triangle up to 'numRows'.

        2. For each row from 1 to numRows:
           - Call `generateRow(i)` which returns the list representing the i-th row of Pascal’s Triangle.
           - Add that row to the result list.

        3. Inside `generateRow(int numRows)`:
           - Start with 1 because the first element in every row of Pascal's Triangle is always 1.
           - Use the combination formula: C(n, r) = C(n, r - 1) * (n - r + 1) / r
             - This formula helps compute the next number in the row without using factorials.
             - For example, next element = previous element * (numRows - col) / col
           - Repeat this to build the entire row.

        4. Return the complete list of rows which forms Pascal's Triangle.
*/
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            result.add(generateRow(i));
        }
        return result;
    }

    //formula based
    private static List<Integer> generateRow(int numRows) {
        List<Integer> list = new ArrayList<>();
        int ans = 1;
        list.add(1);
        for (int col = 1; col < numRows; col++) {
            ans = ans * (numRows - col);
            ans = ans / col;
            list.add(ans);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
