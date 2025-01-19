package arrays.medium.mustdo;

// Problem Link - https://leetcode.com/problems/maximum-subarray/
public class Leetcode_53 {

    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int current  = nums[i];
            sum = Math.max(sum+current, current);
            res = Math.max(sum, res);
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
