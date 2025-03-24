package binary_search.mustdo;

//Problem link = https://leetcode.com/problems/search-insert-position/description/
public class Leetcode_35 {

    /**
     * ### **Simple Explanation of the Approach:**
     *
     * 1. **We are using Binary Search:**
     *    - Instead of checking every number one by one, we look at the middle number (`mid`).
     *    - This helps us find the answer faster.
     *
     * 2. **Check if `mid` is the target:**
     *    - If `nums[mid]` is equal to `target`, return `mid` because we found the number.
     *
     * 3. **If `target` is smaller than `nums[mid]`:**
     *    - This means `target` should be on the **left side** of `mid`, so we move `end` to `mid - 1`.
     *
     * 4. **If `target` is larger than `nums[mid]`:**
     *    - This means `target` should be on the **right side** of `mid`, so we move `start` to `mid + 1`.
     *
     * 5. **When the loop ends, `start` tells us where to insert the target if it's not found.**
     *    - Example: If `target = 8` in `[3,5,7,9,10]`, `start` will be at index `3`, meaning `8` should be inserted there.
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;  // Target found, return index
            } else if (nums[mid] < target) {
                start = mid + 1;  // Move right
            } else {
                end = mid - 1;  // Move left
            }
        }

        return start;  // Insert position when target is not found
    }

    public static void main(String[] args) {
        /*System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7));*/
        System.out.println(searchInsert(new int[]{3,5,7,9,10}, 8));
    }
}
