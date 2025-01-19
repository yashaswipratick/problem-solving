package arrays.easy;

//Problem description - https://leetcode.com/problems/concatenation-of-array/
public class Leetcode_1929 {

    public static int[] getConcatenation(int[] nums) {
         int[] ans = new int[nums.length*2];
         int i = 0;
         while(i < nums.length) {
             ans[i] = nums[i];
             i++;
         }
         int j = 0;
         while(i < ans.length) {
             ans[i] = nums[j];
             i++;
             j++;
         }
         return ans;
    }

    public static int[] getConcatenationOptimised(int[] nums) {
        int n=nums.length;
        int[] ans=new int[2*n];

        System.arraycopy(nums,0,ans,0,n);
        System.arraycopy(nums,0,ans,n,n);
        return ans;
    }

    public static void main(String[] args) {
        int[] concatenation = getConcatenation(new int[]{1, 2, 1});
        for (int i : concatenation) {
            System.out.println(i);
        }
        System.out.println("=========================");
        int[] concatenation1 = getConcatenationOptimised(new int[]{1, 3, 2, 1});
        for (int i : concatenation1) {
            System.out.println(i);
        }
    }
}

/**
 * Read about System.arraycopy() from below
 * https://www.geeksforgeeks.org/system-arraycopy-in-java/
 */
