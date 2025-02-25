package arrays.medium;

//merge sort
public class Leetcode_912 {

    public int[] sortArray(int[] nums) {
        return sort(nums, 0, nums.length - 1);
    }

    private int[] sort(int[] nums, int l, int r) {
        int mid = l + (r-l) / 2;
        if (l == r) {
            return new int[]{nums[l]};
        }
        int[] left = sort(nums, l, mid);
        int[] right = sort(nums, mid+1, r);
        return mergeSort(left, right);
    }

    private int[] mergeSort(int[] num1, int[] num2) {
        int[] res = new int[num1.length + num2.length];
        int l = 0;
        int r = 0;
        int k = 0;

        while (l < num1.length && r < num2.length) {
            if (num1[l] > num2[r]) {
                res[k] = num2[r];
                r++;
            } else {
                res[k] = num1[l];
                l++;
            }
            k++;
        }

        while (l < num1.length) {
            res[k] = num1[l];
            l++;
            k++;
        }

        while (r < num2.length) {
            res[k] = num2[r];
            r++;
            k++;
        }

        return res;
    }

    public static void main(String[] args) {
        Leetcode_912 l = new Leetcode_912();
        l.sortArray(new int[]{5,2,3,1});
    }
}
