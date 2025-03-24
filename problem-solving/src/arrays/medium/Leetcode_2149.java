package arrays.medium;

import java.util.ArrayList;
import java.util.List;

//problem link - https://leetcode.com/problems/rearrange-array-elements-by-sign/description/
//Ref - https://www.youtube.com/watch?v=h4aBagy4Uok&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB&index=9
public class Leetcode_2149 {

    /**
     * Approach
     *
     * Approach for Rearranging Array with Alternate Signs:
     * Understand the Given Conditions:
     * The array nums has an equal number of positive and negative integers.
     * The rearranged array should start with a positive number.
     * Positive and negative numbers should appear alternately.
     *
     * Initialize Index Pointers:
     * positiveIndex = 0: This keeps track of the position where the next positive number should be placed.
     * negativeIndex = 1: This keeps track of the position where the next negative number should be placed.
     *
     * Create a New Array:
     * Initialize a new array arr of the same size as nums to store the rearranged elements.
     *
     * Iterate Through the Input Array nums:
     * Traverse each element in nums one by one.
     * If the element is positive, place it at positiveIndex in arr, then increment positiveIndex by 2.
     * If the element is negative, place it at negativeIndex in arr, then increment negativeIndex by 2.
     * This ensures that positive numbers are placed at even indices (0, 2, 4, …) and negative numbers are placed at odd indices (1, 3, 5, …).
     *
     * Return the Resultant Array:
     * The arr now contains elements arranged in the correct order, satisfying all conditions.
     * @param nums
     * @return
     */
    public static int[] rearrangeArray(int[] nums) {
        int positiveIndex = 0;
        int negativeIndex = 1;

        int[] arr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                arr[negativeIndex] = nums[i];
                negativeIndex += 2;
            } else {
                arr[positiveIndex] = nums[i];
                positiveIndex += 2;
            }
        }
        return arr;
    }

    /**
     * MAintain relative order.
     * also there might be a case poitive > negative or negative > positive.
     * Please solve this case.
     */
    public static int[] rearrangeArrayVariation(int[] nums) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        int[] ans = new int[nums.length];

        for (int i = 0; i<nums.length; i++) {
            if (nums[i] > 0) {
                pos.add(nums[i]);
            }
        }

        for (int i = 0; i<nums.length; i++) {
            if (nums[i] < 0) {
                pos.add(nums[i]);
            }
        }

        if (pos.size() > neg.size()) {
            for (int i = 0; i < neg.size(); i++) {
                ans[2*i] = pos.get(i);
                ans[2*i+1] = neg.get(i);
            }
            int index = neg.size()*2;
            for (int i = neg.size(); i < pos.size(); i++) {
                ans[index] = pos.get(i);
                index++;
            }
        } else {
            for (int i = 0; i < pos.size(); i++) {
                ans[2*i] = pos.get(i);
                ans[2*i+1] = neg.get(i);
            }
            int index = pos.size()*2;
            for (int i = pos.size(); i < neg.size(); i++) {
                ans[index] = neg.get(i);
                index++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        //int[] ans = rearrangeArray(new int[]{3, 1, -2, -5, 2, -4});
        int[] ans = rearrangeArray(new int[]{-1,1});
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println("------------");
        int[] ans1 = rearrangeArrayVariation(new int[]{-1,2,3,4,-3,1});
        for (int i = 0; i < ans1.length; i++) {
            System.out.print(ans1[i] + " ");
        }
    }
}
