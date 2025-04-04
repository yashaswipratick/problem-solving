package binary_search.mustdo;

// Problem link - https://www.geeksforgeeks.org/problems/find-nth-root-of-m5843/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=find-nth-root-of-m
public class GfgFindNthRootOfM {

    public static int nthRoot(int n, int m) {
        int start = 1;
        int end = m;

        while (start <= end){
            int mid = start + (end - start) / 2;

            if (Math.pow(mid, n) == m) {
                return mid;
            } else if (Math.pow(mid, n) < m) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(nthRoot(2, 9));
        System.out.println(nthRoot(3, 9));
        System.out.println(nthRoot(1, 14));
        System.out.println(nthRoot(4, 17));
        System.out.println(nthRoot(6, 64));
        System.out.println(nthRoot(5, 32));
        System.out.println(nthRoot(4, 16));
        System.out.println(nthRoot(7, 100));
    }
}
