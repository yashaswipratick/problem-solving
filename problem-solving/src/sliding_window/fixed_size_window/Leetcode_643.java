package sliding_window.fixed_size_window;

//Problem Link - https://leetcode.com/problems/maximum-average-subarray-i/description/
public class Leetcode_643 {

    public static double findMaxAverage(int[] nums, int k) {
        int i = 0;
        int j = 0;

        double sum = 0;
        double avg = Integer.MIN_VALUE;
        while (j < nums.length) {
            sum += nums[j];

            if (j-i+1 < k) {
                j++;
            } else if (j-i+1 == k) {
                double tempAvg = sum/k;
                avg = Math.max(avg, tempAvg);
                sum -= nums[i];
                i++;
                j++;
            }
        }
        return avg;
    }

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
        System.out.println(findMaxAverage(new int[]{5}, 1));
        System.out.println(findMaxAverage(new int[]{-1}, 1));
    }
}
