package arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Leetcode_229 {

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums.length == 1) {
            list.add(nums[0]);
            return list;
        }
        int count = 1;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                count++;
            } else {
                count = 1;
            }

            if (count > (nums.length / 3)) {
                list.add(nums[i]);
            }
        }
        if (count == 1 && nums.length > 1) {
            list.clear();
            return IntStream.of(nums).boxed().collect(Collectors.toList());
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));
        System.out.println(majorityElement(new int[]{1, 2}));
        System.out.println(majorityElement(new int[]{1}));
    }
}
