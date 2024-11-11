package com.yashaswi.pattern.based.problems.sliding_window.fixed_size_window.gfg;

import java.util.ArrayList;

//problem link = https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
public class MaximumSumSubarraySize {

    private int maxSum(int[] array, int K) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;

        while (j < array.length) {
            sum = sum + array[j]; // sum all te element
            //until the first window hits sum up array elements and store in sum variable.
            if (j-i+1 < K) { // window size formula.
                j++;
            } else if (j-i+1 == K) {
                //once window hit get the maximum,
                // subtract the element from sum at index i,
                // increment i and j.
                max = Math.max(sum, max);
                sum = sum - array[i];
                i++;
                j++;
            }
        }
        return max;
    }

    static long maximumSumSubarray(int K, ArrayList<Integer> Arr, int N){
        int i = 0;
        int j = 0;
        long sum = 0;
        long max = Integer.MIN_VALUE;

        while (j < Arr.size()) {
            sum = sum + Arr.get(j); // sum all te element
            //until the first window hits sum up array elements and store in sum variable.
            if (j-i+1 < K) { // window size formula.
                j++;
            } else if (j-i+1 == K) {
                //once window hit get the maximum,
                // subtract the element from sum at index i,
                // increment i and j.
                max = Math.max(sum, max);
                sum = sum - Arr.get(i);
                i++;
                j++;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(200);
        list.add(300);
        list.add(400);
        System.out.println(maximumSumSubarray(2, list, 4));
    }
}
