package sliding_window.variable_size_window.mustdo;

//problem link - https://leetcode.com/problems/subarray-product-less-than-k/description/
public class Leetcode_713 {

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0; // Edge case: if k is 0 or 1, there are no valid subarrays.

        int count = 0;
        int product = 1;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];

            // Adjust the window size if the product reaches or exceeds k
            while (product >= k && left <= right) {
                product /= nums[left];
                left++;
            }

            // All subarrays ending at `right` and starting from any index between `left` and `right` are valid
            count += right - left + 1;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
        System.out.println(numSubarrayProductLessThanK(new int[]{1, 1, 1, 1}, 2));
        System.out.println(numSubarrayProductLessThanK(new int[]{1, 2, 3}, 6));
    }
}

/**
 * Explanation
 * Explanation
 * Initialize Variables:
 *
 * count to store the number of valid subarrays.
 * product to keep track of the current product of elements in the sliding window.
 * left as the start index of the sliding window.
 * Iterate with Right Pointer:
 *
 * Expand the window by including nums[right] in the product.
 * If product >= k, keep dividing product by nums[left] and move left forward to shrink the window until product < k.
 * Count Valid Subarrays:
 *
 * For each right, all subarrays that end at right and start anywhere from left to right have products less than k.
 * The number of such subarrays is right - left + 1.
 * Return the total count after processing all possible windows.
 */

/**
 *
 * Example Walkthrough
 * For nums = [10, 5, 2, 6] and k = 100:
 *
 * Initialize count = 0, product = 1, left = 0.
 * Traverse with right from 0 to 3:
 * When right = 0: product = 10, count subarrays [10].
 * When right = 1: product = 10 * 5 = 50, count subarrays [10, 5], [5].
 * When right = 2: product = 50 * 2 = 100 (shrink window by moving left), count subarrays [5, 2], [2].
 * When right = 3: product = 30 * 6 = 60, count subarrays [5, 2, 6], [2, 6], [6].
 * Final count = 8, which matches the expected result
 */