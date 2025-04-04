package binary_search.mustdo;

// Problem link - https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/
public class Leetcode_1482 {

    public static int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < (m*k)) return -1;
        int start = findMinInArray(bloomDay);
        int end = findMaxInArray(bloomDay);
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (findPossible(bloomDay, m, k, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private static boolean findPossible(int[] bloomDay, int m, int k, int possibleDays) {
        int count = 0;
        int noOfBookie = 0;

        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= possibleDays) {
                count++;
            } else {
                noOfBookie += (count / k);
                count = 0;
            }
        }
        noOfBookie += (count / k);
        if (noOfBookie >= m) return true;
        return false;
    }

    private static int findMinInArray(int[] bloomDay) {
        int min = bloomDay[0];
        for (int i = 0; i < bloomDay.length; i++) {
            min = Math.min(min, bloomDay[i]);
        }
        return min;
    }

    private static int findMaxInArray(int[] bloomDay) {
        int max = bloomDay[0];
        for (int i = 0; i < bloomDay.length; i++) {
            max = Math.max(max, bloomDay[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(minDays(new int[]{1, 10, 3, 10, 2}, 3, 1));
        System.out.println(minDays(new int[]{7, 7, 7, 7, 13, 11, 12, 7}, 2, 3));
    }
}
