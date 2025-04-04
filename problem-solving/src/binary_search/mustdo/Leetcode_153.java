package binary_search.mustdo;

//Problem link - https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class Leetcode_153 {

    public static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int target = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[start] <= nums[mid]) { // check if left half is sorted, then takes the min which is nums[start] and eliminate left half
                target = Math.min(target, nums[start]);
                start = mid + 1;
            } else { // check if right half is sorted, then takes the min which is nums[mid] and eliminate right half
                target = Math.min(target, nums[mid]);
                end = mid - 1;
            }


        }
        return target;
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(findMin(new int[]{2,3,4,5,1}));
        System.out.println(findMin(new int[]{5,1,2,3}));
        System.out.println(findMin(new int[]{1,2,3,4,5}));
        System.out.println(findMin(new int[]{1}));

        System.out.println(findMin(new int[]{5,1,2,3,4})); // special case
    }
}
