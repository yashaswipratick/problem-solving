package com.yashaswi.pattern.based.problems.sliding_window.fixed_size_window.must_do;

//Problem Link - https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/
//Reference - https://www.youtube.com/watch?v=pBWCOCS636U
public class Leetcode_1423 {

    public static int maxScore(int[] cardPoints, int k) {
        int leftSum = 0;
        int rightSum = 0;
        int maxSum = 0;

        for (int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }

        maxSum = leftSum;

        int rightIndex = cardPoints.length - 1;

        for (int i = k-1; i >= 0; i--) {
            leftSum = leftSum - cardPoints[i];
            rightSum = rightSum + cardPoints[rightIndex];
            rightIndex -= 1;
            maxSum = Math.max(maxSum, leftSum + rightSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{6, 2, 3, 4, 7, 2, 1, 7, 1}, 4));
    }
}
