package arrays.easy;

/**
 * Boyer-Moore Voting Algorithm
 * Take the first element as a source and count as 1
 * loop through the array from index 1
 * check if the value present at index == element then increment the count.
 * if element present at index != element then decrement the count.
 * if count becomes 0 before the iteration completes then put assign current index value to the element,
 * element = nums[i] and increment the count
 */
public class Leetcode_169 {

    public static int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int element = nums[0];
        int count = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == element) {
                count++;
            } else if (nums[i] != element) {
                count--;
            }

            if (count == 0) {
                element = nums[i];
                count++;
            }
        }
        return element;
    }
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}
