package sliding_window.variable_size_window.mustdo;

import java.util.Arrays;

public class Leetcode_1838 {

    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);  // Step 1: Sort the array

        long total = 0;      // Total of the window elements
        int left = 0;
        int maxFreq = 0;     // Variable to store the maximum frequency found

        // Step 2: Sliding window
        for (int right = 0; right < nums.length; right++) {
            total += nums[right];  // Add the current element to the window sum

            // Step 3: Calculate the cost to make all elements in the window equal to nums[right]
            while (nums[right] * (right - left + 1) > total + k) {
                // If the cost is too high, slide the window
                total -= nums[left];
                left++;
            }

            // Step 4: Update the max frequency
            maxFreq = Math.max(maxFreq, right - left + 1);
        }

        return maxFreq;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 4};
        int k1 = 5;
        System.out.println(maxFrequency(nums1, k1));  // Output: 3

        int[] nums2 = {1, 4, 8, 13};
        int k2 = 5;
        System.out.println(maxFrequency(nums2, k2));  // Output: 2

        int[] nums3 = {3, 9, 6};
        int k3 = 2;
        System.out.println(maxFrequency(nums3, k3));  // Output: 1
    }
}

/**
 * Approach
 * Sort nums so that you can easily calculate the cost of converting each element in a window to the target element (the end of the window).
 * Use a sliding window:
 * For each element at the end of the window, calculate the number of operations required to convert all previous elements in the window to match it.
 * Track the maximum length of such a window where operations are within the k limit.
 *
 * Here’s the approach in steps:
 *
 * Sort the Array: Sort nums to bring similar numbers close to each other. This minimizes the number of increments needed to make values in a window equal to the current target.
 *
 * Use a Sliding Window with a Cumulative Sum:
 *
 * Keep a running cumulative sum of the window to calculate the total operations needed to make every element in the window equal to the end of the window.
 * Let’s call the end of the window right, and the start of the window left.
 * For each new element at right, calculate the total cost to make all elements in the window equal to nums[right].
 * Calculate Cost Efficiently:
 *
 * For the window [left, ..., right] to make all elements equal to nums[right], the cost can be calculated as:
 * cost
 * =
 * window length
 * ×
 * target element
 * −
 * cumulative sum of the window
 * cost=window length×target element−cumulative sum of the window
 * If the cost exceeds k, slide the window forward by moving left to left + 1.
 * Track the Maximum Window Size:
 *
 * Each time you have a valid window (where cost <= k), calculate its length (right - left + 1) and update the maximum frequency.
 *
 * Example Walkthrough
 * Let’s go through nums = [1, 2, 4] with k = 5:
 *
 * Sort nums: [1, 2, 4]
 *
 * Initialize left = 0, right = 0, total = 0, maxFreq = 0.
 *
 * Expand the window:
 *
 * right = 0: total = 1 (only 1 in the window)
 * Cost to make the window [1] all 1s is 0, within k. Update maxFreq = 1.
 * right = 1: total = 3 (window [1, 2])
 * Cost to make the window [1, 2] all 2s is 2 * 2 - 3 = 1, within k. Update maxFreq = 2.
 * right = 2: total = 7 (window [1, 2, 4])
 * Cost to make the window [1, 2, 4] all 4s is 3 * 4 - 7 = 5, within k. Update maxFreq = 3.
 * The result is 3, as we can make all elements in the array 4 by using 5 operations.
 */
