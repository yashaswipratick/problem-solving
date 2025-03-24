package arrays.medium.mustdo;

//Problem link - https://leetcode.com/problems/product-of-array-except-self/
public class Leetcode_238 {

    /**
     * Approach
     *
     * Initialize two empty arrays, L and R where for a given index i,
     * L[i] would contain the product of all the numbers to the left of i and R[i]
     * would contain the product of all the numbers to the right of i.
     *
     * We would need two different loops to fill in values for the two arrays.
     * For the array L, L[0] would be 1 since there are no elements to the left of the first element.
     * For the rest of the elements, we simply use L[i]=L[i−1]∗nums[i−1].
     * Remember that L[i] represents product of all the elements to the left of element at index i.
     *
     * For the other array, we do the same thing but in reverse i.e.
     * we start with the initial value of 1 in R[length−1] where length is the number of
     * elements in the array, and keep updating R[i] in reverse. Essentially, R[i]=R[i+1]∗nums[i+1].
     * Remember that R[i] represents product of all the elements to the right of element at index i.
     *
     * Once we have the two arrays set up properly, we simply iterate over the input
     * array one element at a time, and for each element at index i, we find the product
     * except self as L[i]∗R[i].
     * TC - O(n), SC - O(n)
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i-1] * nums[i-1];
        }

        right[right.length - 1] = 1;
        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = right[i+1] * nums[i+1];
        }


        int[] ans = new int[nums.length];
        for (int i = 0; i < left.length; i++) {
            ans[i] = left[i] * right[i];
        }

        return ans;
    }

    /**
     * Algorithm
     *
     * Initialize the empty answer array where for a given index i,
     * answer[i] would contain the product of all the numbers to the left of i.
     *
     * We construct the answer array the same way we constructed the L array in the previous approach.
     * These two algorithms are exactly the same except that we are trying to save up on space.
     *
     * The only change in this approach is that we don't explicitly build the R array from before.
     * Instead, we simply use a variable to keep track of the running product of elements to the right
     * and we keep updating the answer array by doing answer[i]=answer[i]∗R. For a given index i,
     * answer[i] contains the product of all the elements to the left and R would contain product of
     * all the elements to the right. We then update R as R=R∗nums[i]
     *
     * TC - O(n), SC - O(1)
     * @param nums
     * @return
     */
    public static int[] productExceptSelfOptimised(int[] nums) {
        // The length of the input array
        int length = nums.length;

        // Final answer array to be returned
        int[] answer = new int[length];

        // answer[i] contains the product of all the elements to the left
        // Note: for the element at index '0', there are no elements to the left,
        // so the answer[0] would be 1
        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            // answer[i - 1] already contains the product of elements to the left of 'i - 1'
            // Simply multiplying it with nums[i - 1] would give the product of all
            // elements to the left of index 'i'
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        // R contains the product of all the elements to the right
        // Note: for the element at index 'length - 1', there are no elements to the right,
        // so the R would be 1
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            // For the index 'i', R would contain the
            // product of all elements to the right. We update R accordingly
            answer[i] = answer[i] * R;
            R *= nums[i];
        }

        return answer;
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        //int[] ans = productExceptSelf(new int[]{1, 2, 3, 4});
        int[] ans = productExceptSelf(new int[]{-1,1,0,-3,3});
        System.out.println("========================================================");
        printArray(ans);
    }
}
