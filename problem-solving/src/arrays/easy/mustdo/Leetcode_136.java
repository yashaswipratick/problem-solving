package arrays.easy.mustdo;

/**
 * Approach
 *
 * There is a mathematical formula to find single number which is not repeated
 * is in all the array elements try to
 * sum the XOR operation for all the number where in entire array if there is only one single number
 * which is not repeated then it will give you the number.
 *
 * initiate sum to 0;
 * then iterate over array and perform the XOR operation.
 */
public class Leetcode_136 {

    public static int singleNumber(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum ^= i;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 2, 1}));
        System.out.println(singleNumber(new int[]{4,1,2,1,2}));
        System.out.println(singleNumber(new int[]{1}));
    }
}
