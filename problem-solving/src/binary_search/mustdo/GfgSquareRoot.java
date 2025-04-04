package binary_search.mustdo;

// problem link = https://www.geeksforgeeks.org/problems/square-root/0?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=square-root
public class GfgSquareRoot {

    static int floorSqrt(int n) {
        int start = 1;
        int end = n;
        int ans = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if ((mid * mid) <= n) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(floorSqrt(4));
        System.out.println(floorSqrt(11));
        System.out.println(floorSqrt(1));
    }
}
