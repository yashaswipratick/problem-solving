package arrays.easy.mustdo;

import java.util.*;

public class Leetcode_448 {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for(int i = 1; i<=nums.length; i++) {
            if(map.containsKey(i)) {
                map.remove(i);
            } else {
                map.put(i, 1);
            }
        }
        list.addAll(map.keySet());
        return list;
    }


    /**
     * We definitely need to keep track of all theuniquenumbers that appear in the array. However, we don't want to use any extra space for it. This solution that we will look at in just a moment springs from the fact that
     *
     * All the elements are in the range [1, N]
     *
     * Since we are given this information, we can make use of the input array itself to somehowmark visitednumbers and then find our missing numbers. Now, we don't want to change the actual data in the array but who's stopping us from changing themagnitudeof numbers in the array? That is the basic idea behind this algorithm.
     *
     * We will be negating the numbers seen in the array and use the sign of each of the numbers for finding our missing numbers. We will be treating numbers in the array as indices and mark corresponding locations in the array as negative.
     *
     * Iterate over the input array one element at a time.
     * For each elementnums[i], mark the element at the corresponding location negative if it's not already marked so i.e.nums[nums[i]−1]×−1.
     * Now, loop over numbers from1⋯Nand for each number check ifnums[j]is negative. If it is negative, that means we've seen this number somewhere in the array.
     * Add all the numbers to the resultant array which don't have their corresponding locations marked as negative in the original array.
     * @param nums
     * @return
     */
    private static List<Integer> findDisappearedNumbersOptimised(int[] nums) {

        // Iterate over each of the elements in the original array
        for (int i = 0; i < nums.length; i++) {

            // Treat the value as the new index
            int newIndex = Math.abs(nums[i]) - 1;

            // Check the magnitude of value at this new index
            // If the magnitude is positive, make it negative
            // thus indicating that the number nums[i] has
            // appeared or has been visited.
            if (nums[newIndex] > 0) {
                nums[newIndex] *= -1;
            }
        }

        // Response array that would contain the missing numbers
        List<Integer> result = new LinkedList<Integer>();

        // Iterate over the numbers from 1 to N and add all those
        // that have positive magnitude in the array
        for (int i = 1; i <= nums.length; i++) {

            if (nums[i - 1] > 0) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(findDisappearedNumbersOptimised(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(findDisappearedNumbersOptimised(new int[]{1,1}));
    }
}
