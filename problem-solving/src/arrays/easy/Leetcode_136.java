package arrays.easy;

//Problem link - https://leetcode.com/problems/single-number/
public class Leetcode_136 {

    public static int singleNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum ^= nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 2, 1}));
    }
}


/**
 * Approach
 * Initialization:
 *
 * sum is initialized to 0.
 * Iterate Through the Array:
 *
 * For every element nums[i] in the array:
 * Perform sum ^= nums[i].
 * This XORs the current value of sum with nums[i].
 * Final Result:
 *
 * At the end of the loop, all numbers that appear twice will cancel out (because x⊕x=0).
 * The number that appears only once will remain in sum.
 *
 * For input: nums = [4, 1, 2, 1, 2]
 *
 * Initial sum = 0.
 * Process each number in the array:
 * sum ^= 4 → sum = 0 ^ 4 = 4.
 * sum ^= 1 → sum = 4 ^ 1 = 5.
 * sum ^= 2 → sum = 5 ^ 2 = 7.
 * sum ^= 1 → sum = 7 ^ 1 = 6.
 * sum ^= 2 → sum = 6 ^ 2 = 4.
 * Final sum = 4, which is the single number.
 */