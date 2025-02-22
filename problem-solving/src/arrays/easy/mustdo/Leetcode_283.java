package arrays.easy.mustdo;

public class Leetcode_283 {

    public static void moveZeroes(int[] nums) {
        int countZeros = 0;

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                countZeros++;
            } else {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }

        int i = nums.length - countZeros;
        while (i < nums.length) {
            nums[i] = 0;
            i++;
    }
}

public static void main(String[] args) {

}
}
