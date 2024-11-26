package arrays.medium.mustdo;

import java.util.HashMap;

//Problem Link - https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=longest-sub-array-with-sum-k
public class LongestSubArrayWithGivenSum {

    public static int lenOfLongestSubarr(int[] arr, int k) {
        long sum = 0;
        int maxLength = 0;
        HashMap<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            if (sum == k) {
                maxLength = Math.max(maxLength, i + 1);
            }

            long rem = sum - k;

            if (map.containsKey(rem)) {
                int len = i - map.get(rem);
                maxLength = Math.max(maxLength, len);
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lenOfLongestSubarr(new int[]{10, 5, 2, 7, 1, 9}, 15));
        System.out.println(lenOfLongestSubarr(new int[]{-1, 2, -3}, -2));
        System.out.println(lenOfLongestSubarr(new int[]{1, -1, 5, -2, 3}, 3));
    }
}
