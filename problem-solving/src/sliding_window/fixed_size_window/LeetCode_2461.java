package sliding_window.fixed_size_window;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_2461 {

    public static long maximumSubarraySum(int[] nums, int k) {
int i = 0;
long sum = 0;
long maxSum = 0;
Map<Integer, Integer> map = new HashMap<>();

for (int j = 0; j < nums.length; j++) {
    map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
    sum += nums[j];

    // Adjust window until it contains distinct elements
    while (map.get(nums[j]) > 1) { //1, 5, 4, 2, 9, 9, 9, 8, 7
map.put(nums[i], map.get(nums[i]) - 1);
if (map.get(nums[i]) == 0) {
    map.remove(nums[i]);
}
sum -= nums[i];
i++;
    }

    // Check if current window size is k and update maxSum
    if (j - i + 1 == k) {
maxSum = Math.max(maxSum, sum);
map.put(nums[i], map.get(nums[i]) - 1);
if (map.get(nums[i]) == 0) {
    map.remove(nums[i]);
}
sum -= nums[i];
i++;
    }
}
return maxSum;
    }

    public static void main(String[] args) {
//System.out.println(maximumSubarraySum(new int[]{1, 5, 4, 2, 9, 9, 9}, 3));
System.out.println(maximumSubarraySum(new int[]{1, 5, 4, 2, 9, 9, 9, 8, 7}, 3));
//System.out.println(maximumSubarraySum(new int[]{4, 4, 4}, 3));
    }
}