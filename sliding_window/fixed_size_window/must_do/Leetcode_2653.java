package sliding_window.fixed_size_window.must_do;

import java.util.ArrayList;
import java.util.List;

//Problem Link - https://leetcode.com/problems/sliding-subarray-beauty/description/
public class Leetcode_2653 {

    public static int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int[] count = new int[50]; // Array to track frequencies of negative numbers from -50 to -1
        List<Integer> result = new ArrayList<>();

        int i = 0, j = 0;

        while (j < nums.length) {
            if (nums[j] < 0) {
                count[-nums[j] - 1]++; // Store the frequency of each negative number
            }

            if (j - i + 1 == k) {
                result.add(getXthSmallest(count, x));

                // Slide the window
                if (nums[i] < 0) {
                    count[-nums[i] - 1]--;
                }
                i++;
            }
            j++;
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int getXthSmallest(int[] count, int x) {
        int runningCount = 0;
        for (int i = 0; i < count.length; i++) {
            runningCount += count[i];
            if (runningCount >= x) {
                return -i - 1;
            }
        }
        return 0; // Return 0 if there are fewer than x negative numbers in the window
    }

    public static void main(String[] args) {
        //int[] subarrayBeauty = getSubarrayBeauty(new int[]{-46, -34, -46}, 3, 3);
        int[] subarrayBeauty = getSubarrayBeauty(new int[]{-18,-18,12}, 2, 3);
        System.out.println();
    }
}
