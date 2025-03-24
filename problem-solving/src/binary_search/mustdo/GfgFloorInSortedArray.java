package binary_search.mustdo;

//problem Link - https://www.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1?track=DSASP-Searching&amp%253BbatchId=154&utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=floor-in-a-sorted-array
public class GfgFloorInSortedArray {

    static int findFloor(int[] arr, int x) {
        int start = 0;
        int end = arr.length - 1;

        /*if (arr.length == 1 && arr[0] < x) {
            return 0;
        }*/

        while (start <= end) {
            int mid = start + (end-start)/2;
            if (arr[mid] <= x && mid <= arr.length - 2 && arr[mid+1] > x) {
                return mid;
            } else if (arr[mid] <= x && mid == arr.length - 1) {
                return mid;
            } else if (arr[mid] > x) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(findFloor(new int[]{1, 2, 8, 10, 10, 12, 19}, 5));
        System.out.println(findFloor(new int[]{1, 2, 8, 10, 10, 12, 19}, 11));
        System.out.println(findFloor(new int[]{1, 2, 8, 10, 10, 12, 19}, 0));
        System.out.println(findFloor(new int[]{2}, 6));
        System.out.println(findFloor(new int[]{8, 18, 26, 28, 32, 35, 37, 38, 42, 47, 49, 51, 51, 67, 80}, 80));
    }
}
