package arrays.easy;


// Problem based on move zero's to the end algorithm

/**
 * Approach
 * First mark all the nums value to -1 which is matching the val.
 * Run the loop from 0th index and check the condition that if both i and j are -1 then continue
 * else if i = -1 and j not equals -1 then swap and increment i
 * else both are not -1 the increment i.
 */
public class Leetcode_27 {

    public static int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                nums[i] = -1;
                count++;
            }
        }

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[i] == -1 && nums[j] == -1) {
                continue;
            } else if (nums[i] == -1 && nums[j] != -1) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            } else {
                i++;
            }
        }
        return nums.length-count;
    }

    /**
     * When nums[j]equals to the given value, skip this element by incrementingj.
     * As long asnums[j]=val, we copy nums[j]to nums[i]and increment both indexes
     * at the same time. Repeat the process until
     * reaches the end of the array and the new length is i.
     * @param nums
     * @param val
     * @return
     */

        public int removeElementOptimised(int[] nums, int val) {
            int i = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] != val) {
                    nums[i] = nums[j];
                    i++;
                }
            }
            return i;
        }
    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3, 2, 2, 3}, 3));
        System.out.println(removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
    }
}
