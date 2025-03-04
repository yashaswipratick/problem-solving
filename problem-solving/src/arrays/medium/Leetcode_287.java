package arrays.medium;

import java.util.HashSet;

// Problem link - https://leetcode.com/problems/find-the-duplicate-number/
public class Leetcode_287 {

    public static int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i<nums.length; i++) {
            if(!set.contains(nums[i])) {
                set.add(nums[i]);
            } else {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * ✅ Approach Explanation:
     * 1️⃣ Create a boolean array `foundDups` of size `nums.length` to track seen numbers.
     * 2️⃣ Iterate through the `nums` array:
     *     - If `foundDups[num]` is `true`, it means `num` is a duplicate → return `num`.
     *     - Otherwise, mark `foundDups[num] = true` to indicate that `num` has been encountered.
     * 3️⃣ If no duplicate is found (which shouldn't happen in a valid input), return `1` as a fallback.
     * @param nums
     * @return
     */
    public static int findDuplicateOptimised(int[] nums) {
        boolean[] foundDups = new boolean[nums.length];
        for (int num : nums) {
            if (foundDups[num]) return num;
            foundDups[num] = true;
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicateOptimised(new int[]{1, 3, 4, 2, 2}));
        System.out.println(findDuplicateOptimised(new int[]{3,1,3,4,2}));
        System.out.println(findDuplicateOptimised(new int[]{3,3,3,3,3}));
    }
}
