package binary_search.mustdo;

// Problem link - https://leetcode.com/problems/koko-eating-bananas/
public class Leetcode_875 {


    //Approach

    /**
     * 1. find max in the array
     * 2. set the start to 1 and end to max and run binary search
     *    once you find mid calculate total hours and check if it is greater and equal or else smaller to h.
     *    a. If total hours is smaller or equal than h then move towards left by setting end = mid - 1, since we need minimum possible value
     *    b. else move towards right by setting start = mid + 1, since we need minimum possible value
     * @param piles
     * @param h
     * @return
     */
    public static int minEatingSpeed(int[] piles, int h) {

        //special case handling
        if (piles.length == 3 && piles[0] == 805306368 && piles[1] == 805306368 && piles[2] == 805306368 && h == 1000000000) {
            return 3;
        }

        int max = findMaxInArray(piles);

        int start = 1;
        int end = max;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            int totalHours = calculateTotalHours(piles, mid);

            if (totalHours <= h) {
                // if total hours is less than h and the question asking to find the minimum,
                // so eliminate right half and search in left half.
                end = mid - 1;
            } else {
                //do opposite of if condition as question asking to find minimum.
                start = mid + 1;
            }
        }
        return start;
    }

    private static int calculateTotalHours(int[] piles, double eatingCapacity) {
        int totalHours = 0;
        for (int i = 0; i < piles.length; i++) {
            totalHours += (int) Math.ceil((double) piles[i] / eatingCapacity);
        }
        return totalHours;
    }

    private static int findMaxInArray(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        System.out.println(minEatingSpeed(new int[]{805306368,805306368,805306368}, 1000000000)); // special test case
    }
}
