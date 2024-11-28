package arrays.easy;

import java.util.HashMap;
import java.util.Map;

//Problem Link - https://leetcode.com/problems/two-sum/description/
public class Leetcode_1 {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (!map.containsKey(diff)) {
                map.put(nums[i], i);
            } else {
                return new int[]{map.get(diff), i};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{2, 7, 11, 15}, 9));
    }
}
