package arrays.easy;

//Problem Link - https://leetcode.com/problems/majority-element/
public class Leetcode_169 {

    public static int majorityElement(int[] nums) {
        int count = 0;
        int element = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                count = 1;
                element = nums[i];
            } else if (element == nums[i]) {
                count++;
            } else {
                count--;
            }
        }

        int majElemTotalCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (element == nums[i]) {
                majElemTotalCount++;
            }
        }

        if (majElemTotalCount > nums.length / 2) {
            return element;
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
        System.out.println(majorityElement(new int[]{1,1}));
    }
}

/**
 * @Approach-1
 * Take Hash Map and count freq of each element.
 * Iterate throiugh the map and check the element frequence greater than arr length / 2.
 * The Element which count is greater will be the answer.
 *
 * @Optimal-Approach: Moore’s Voting Algorithm:
 *
 * Initialize 2 variables:
 * Count –  for tracking the count of element
 * Element – for which element we are counting
 *
 * Traverse through the given array.
 * If Count is 0 then store the current element of the array as Element.
 * If the current element and Element are the same increase the Count by 1.
 * If they are different decrease the Count by 1.
 * The integer present in Element should be the result we are expecting
 */