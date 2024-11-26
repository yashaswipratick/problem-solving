package arrays.easy;

//Problem Link - https://leetcode.com/problems/max-consecutive-ones/description/
public class Leetcode_485 {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 1) {
                count++;
            } else {
                count = 0;
            }
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
    }
}
