package arrays.medium;

//Problem description - https://leetcode.com/problems/maximum-subarray/description/
//Ref - https://www.youtube.com/watch?v=AHZpyENo7k4
public class Leetcode_53 {

    /*
        Approach: Kadane's Algorithm (Simple Explanation)

            - We are trying to find the maximum sum of a subarray from the given array.

            - We use a variable `sum` to keep adding elements one by one.

            - If at any point the `sum` becomes greater than the `max`, we update `max`.

            - If `sum` becomes negative, we reset it to 0 because a negative
              sum will not help in forming a maximum subarray.

            - This way we keep tracking the maximum subarray sum as we go through the array once.

            - This approach works in O(n) time and is very efficient.

            Example:
            For array [-2,1,-3,4,-1,2,1,-5,4],
            the subarray [4,-1,2,1] has the largest sum = 6
*/
    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum);

            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
        int[] nums1 = {-2,-3,4,-1,-2,1,5,-3};
        System.out.println(maxSubArray(nums1));
    }
}
