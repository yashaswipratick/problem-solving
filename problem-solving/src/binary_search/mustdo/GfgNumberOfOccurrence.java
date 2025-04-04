package binary_search.mustdo;

//Problem Link - https://www.geeksforgeeks.org/problems/number-of-occurrence2259/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=number-of-occurrence
//Problem base on Leetcode_24 pattern
public class GfgNumberOfOccurrence {

    public int countFreq(int[] arr, int target) {
        int firstOccurrence = findFirstOccurrence(arr, target);
        int lastOccurrence = findLastOccurrence(arr, target);

        if (firstOccurrence == -1 && lastOccurrence == -1) {
            return 0;
        }
        return (lastOccurrence - firstOccurrence + 1);
    }

    private int findFirstOccurrence(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int res = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                res = mid;
                end = mid - 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    private int findLastOccurrence(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int res = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                res = mid;
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        GfgNumberOfOccurrence occurrence = new GfgNumberOfOccurrence();

        System.out.println(occurrence.countFreq(new int[]{1, 1, 2, 2, 2, 2, 3}, 2));
        System.out.println(occurrence.countFreq(new int[]{1, 1, 2, 2, 2, 2, 3}, 4));
        System.out.println(occurrence.countFreq(new int[]{8, 9, 10, 12, 12, 12}, 12));
    }
}
