package com.yashaswi.pattern.based.problems.sliding_window.fixed_size_window;

//Problem Link - https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/
public class Leetcode_1343 {

    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0, count = 0;
        int requiredSum = k * threshold;

        // Initialize the first window
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        // Check if the initial window meets the condition
        if (sum >= requiredSum) count++;

        // Slide the window over the array
        for (int i = k; i < arr.length; i++) {
            sum += arr[i] - arr[i - k]; // Slide the window: add new element, remove old
            if (sum >= requiredSum) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(numOfSubarrays(new int[]{2, 2, 2, 2, 5, 5, 5, 8}, 3, 4));
        System.out.println(numOfSubarrays(new int[]{11,13,17,23,29,31,7,5,2,3}, 3, 5));
    }
}
