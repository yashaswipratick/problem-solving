package arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Problem link - https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
public class Leetcode_442 {

    /**
     * Approach similar to Leetcode_287.
     * Just take 1 size greater array than your input array and
     * iterate over each index and if found in  dupsFrequency then increment frequency
     * and in second for loop check if dupsFrequency has frequency greater than 1 for any index
     * If yes then store in list and return the list.
     * @param nums
     * @return
     */
    public static List<Integer> findDuplicates(int[] nums) {
        int[] dupsFrequency = new int[nums.length+1];

        Arrays.fill(dupsFrequency, 0);
        for(int num : nums) {
            dupsFrequency[num]++;
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < dupsFrequency.length; i++) {
            if (dupsFrequency[i] > 1) {
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(findDuplicates(new int[]{1,1,2}));
        System.out.println(findDuplicates(new int[]{}));
    }
}
