package com.yashaswi.pattern.based.problems.sliding_window.variable_size_window;

//Problem link - https://leetcode.com/problems/minimum-size-subarray-sum/description/
public class Leetcode_209 {

    //initial approach
    public static int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        while (j < nums.length) {
            sum += nums[j];
            if (sum > target) {
                while (sum > target) {
                    ans = Math.min(ans, j - i + 1);
                    sum -= nums[i];
                    i++;
                }
            }
            if (sum == target) {
                ans = Math.min(ans, j - i + 1);
            }
            j++;
        }
        return ans != Integer.MAX_VALUE ? ans : 0;
    }

    //optimised code.
    public static int minSubArrayLenOptimised(int target, int[] nums) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        while (j < nums.length) {
            sum += nums[j];

            while (sum >= target) { // Change this condition
                ans = Math.min(ans, j - i + 1); // Update ans inside the loop
                sum -= nums[i];
                i++;
            }
            j++;
        }

        return ans != Integer.MAX_VALUE ? ans : 0;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLenOptimised(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLenOptimised(4, new int[]{1,4,4}));
        System.out.println(minSubArrayLenOptimised(11, new int[]{1,1,1,1,1,1,1,1}));

        //optimisation and code refactoring required for this input
        System.out.println(minSubArrayLenOptimised(11, new int[]{1,2,3,4,5}));
    }
}
