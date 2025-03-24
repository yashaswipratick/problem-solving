package binary_search.mustdo;

//Problem link = https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
public class Leetcode_24 {

    /**
     * Approach
     * Find 1st occurrence using findFirstOccurrence method.
     * if you find the mid-equals to target then store the mid in res
     * and shift end to mid - 1 index inside if condition.
     *
     * Repeat the above until you fine the first index.
     *
     * Find last occurrence using findLastOccurrence method.
     * Find last occurrence using findLastOccurrence method.
     * if you find the mid-equals to target then store the mid in res
     * and shift start to mid + 1 index inside if condition.
     *
     * Repeat the above until you find the last index.
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int firstOccurrence = findFirstOccurrence(nums, target);
        int lastOccurrence = findLastOccurrence(nums, target);

        int[] arr = new int[2];
        arr[0] = firstOccurrence;
        arr[1] = lastOccurrence;
        return arr;
    }

    private static int findFirstOccurrence(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        int res = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                res = mid;
                end = mid - 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return res;
    }

    private static int findLastOccurrence(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        int res = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                res = mid;
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] res = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(res[0] + " -> " + res[1]);

        int[] res1 = searchRange(new int[]{5,7,7,8,8,10}, 6);
        System.out.println(res1[0] + " -> " + res1[1]);

        int[] res2 = searchRange(new int[]{}, 0);
        System.out.println(res2[0] + " -> " + res2[1]);
    }
}
