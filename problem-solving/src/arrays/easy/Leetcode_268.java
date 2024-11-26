package arrays.easy;

//Problem Link - https://leetcode.com/problems/missing-number/description/
public class Leetcode_268 {

    public static int missingNumber(int[] nums) {
        int actualSum = (nums.length * (nums.length+1)) / 2;
        int expectedSum = 0;
        for (int elem : nums) {
            expectedSum += elem;
        }

        return actualSum - expectedSum;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3, 0, 1}));
        System.out.println(missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }
}
/**
 * Approach:
 *
 * For finding missing number there is a formula.
 *
 * calculate the actual sum using (n*(n+1))/2; n -> length of the array
 * The above formula will give the sum of all the natural number from 0 to n.
 *
 * Now calculate the sum of all elements present in an array.
 * the array elements sum is expected sum.
 *
 * missing number = actualSum - expectedSum.
 */
