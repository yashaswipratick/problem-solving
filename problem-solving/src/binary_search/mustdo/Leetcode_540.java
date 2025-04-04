package binary_search.mustdo;

//Problem link - https://leetcode.com/problems/single-element-in-a-sorted-array/description/
public class Leetcode_540 {

    public int singleNonDuplicate(int[] nums) {
        //eliminate edge cases:

        if (nums.length == 1) return nums[0];

        if (nums[0] != nums[1]) return nums[0];

        if (nums[nums.length-1] != nums[nums.length-2]) return nums[nums.length-1];

        //logic part
        int start = 1;
        int end = nums.length - 2;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]) {
                return nums[mid];
            }

            //Key concept
            //(even, odd) index = It means element is on right half. Eliminate left half
            //(odd, even) index = It means element is on left half. Eliminate right half.
            if ((mid % 2 == 1 && nums[mid] == nums[mid-1]) ||
                    (mid % 2 == 0 && nums[mid] == nums[mid+1])) {
                start = mid + 1; // eliminate the left half. Element is in right half
            } else {
                end = mid - 1; // eliminate right half. element is in left half.
            }
        }

        return -1;
    }
    public static void main(String[] args) {

    }
}
