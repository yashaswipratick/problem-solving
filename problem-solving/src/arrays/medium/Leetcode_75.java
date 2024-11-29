package arrays.medium;


//Problem Link - https://leetcode.com/problems/sort-colors/description/
public class Leetcode_75 {

    public static void sortColors(int[] nums) {
        int mid = 0;
        int low = 0;
        int high = nums.length-1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else if (nums[mid]==2) {
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }
    }

    public static void main(String[] args) {
        sortColors(new int[]{2,0,2,1,1,0});
        sortColors(new int[]{2,0,1});
    }
}
/**
 * Approach - 1
 * Create three variable for 0,1,2
 * Keep count of 0,1,2 from the array in the respective 3 variables.
 * now run 3 loops to keep the number of elements for each variable count in the array.
 *
 * Optimal Approach: - Dutch National flag algorithm
 *
 * Note: Here in this tutorial we will work based on the value of the mid pointer.
 *
 * The steps will be the following:
 *
 * First, we will run a loop that will continue until mid <= high.
 * There can be three different values of mid pointer i.e. arr[mid]
 * If arr[mid] == 0, we will swap arr[low] and arr[mid] and will increment both low and mid. Now the subarray from index 0 to (low-1) only contains 0.
 * If arr[mid] == 1, we will just increment the mid pointer and then the index (mid-1) will point to 1 as it should according to the rules.
 * If arr[mid] == 2, we will swap arr[mid] and arr[high] and will decrement high. Now the subarray from index high+1 to (n-1) only contains 2.
 * In this step, we will do nothing to the mid-pointer as even after swapping, the subarray from mid to high(after decrementing high) might be unsorted. So, we will check the value of mid again in the next iteration.
 * Finally, our array should be sorted.
 */