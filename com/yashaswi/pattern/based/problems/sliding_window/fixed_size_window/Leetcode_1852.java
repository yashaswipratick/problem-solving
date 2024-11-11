package com.yashaswi.pattern.based.problems.sliding_window.fixed_size_window;

import java.util.*;

//problem link - https://leetcode.com/problems/distinct-numbers-in-each-subarray/description/
public class Leetcode_1852 {

    public static int[] distinctNumbers(int[] nums, int k) {
        int i = 0, j = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[nums.length - k + 1];
        int idx = 0;

        while (j < nums.length) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            // Check if the window size is reached
            if (j - i + 1 == k) {
                result[idx++] = map.size();

                // Adjust the left side of the window
                int count = map.get(nums[i]);
                if (count > 1) {
                    map.put(nums[i], count - 1);
                } else {
                    map.remove(nums[i]);
                }
                i++; // Slide the window
            }
            j++;
        }
        return result;
    }

    // optimised via chatgpt
    public static int[] distinctNumberOptimised(int[] nums, int k) {
        int i = 0, j = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[nums.length - k + 1];
        int idx = 0;

        while (j < nums.length) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            // Check if the window size is reached
            if (j - i + 1 == k) {
                result[idx++] = map.size();

                // Adjust the left side of the window
                int count = map.get(nums[i]);
                if (count > 1) {
                    map.put(nums[i], count - 1);
                } else {
                    map.remove(nums[i]);
                }
                i++; // Slide the window
            }
            j++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(distinctNumbers(new int[]{1, 2, 3, 2, 2, 1, 3}, 3));
        System.out.println(distinctNumbers(new int[]{1,1,1,1,2,3,4}, 4));
    }
}
