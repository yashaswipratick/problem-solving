package binary_search.mustdo;

//problem link - https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
public class Leetcode_81 {

    public static boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return true;
            } if(nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                end--;
                continue;
            }

            else if (nums[start] <= nums[mid]) { // check if left half is sorted
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid - 1;// eliminate right half as target lies in left half
                } else {
                    start = mid + 1;// eliminate left half as target lies in right half and move right
                }
            } else {
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid + 1; //eliminate left half as target lies in right half and move right
                } else {
                    end = mid - 1; //eliminate right half as target lies in left half and move left
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{2,5,6,0,0,1,2}, 0));
        System.out.println(search(new int[]{2,5,6,0,0,1,2}, 3));
        System.out.println(search(new int[]{3,3,1,3,3,3,3}, 1));
    }
}
