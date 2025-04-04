package binary_search;

//Problem link - https://www.geeksforgeeks.org/problems/row-with-max-1s0023/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=row-with-max-1s
public class GfgRowWithMaxOnes {

    public static int rowWithMax1s(int matrix[][]) {
        int ans = -1;
        int max = 0;

        for (int i = 0; i < matrix.length; i++) {
            int onesCount = findFirstOcurenceIndex(matrix[i], 1);
            if (onesCount > max) {
                ans = i;
                max = onesCount;
            }
        }
        return ans;
    }

    private static int findFirstOcurenceIndex(int[] matrix, int i) {
        int start = 0;
        int end = matrix.length - 1;
        int index = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (matrix[mid] == i) {
                index = mid;
                end = mid - 1;
            } else if (matrix[mid] == 0) {
                start = mid + 1;
            }
        }

        return index > -1 ? (matrix.length - index) : -1;
    }

    public static void main(String[] args) {
        System.out.println(rowWithMax1s(new int[][]{{0, 1, 1, 1}, {0, 0, 1, 1}, {1, 1, 1, 1}, {0, 0, 0, 0}}));
        System.out.println(rowWithMax1s(new int[][]{{0, 0}, {1, 1}}));
        System.out.println(rowWithMax1s(new int[][]{{0, 0}, {0, 0}}));
        System.out.println(rowWithMax1s(new int[][]{
                {0,0,0,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1,1},
                {0,0,0,0,0,1,1,1,1},
                {0,0,0,0,1,1,1,1,1},
                {0,0,0,0,0,0,1,1,1},
                {1,1,1,1,1,1,1,1,1},
                {0,0,0,0,0,1,1,1,1},
                {1,1,1,1,1,1,1,1,1},
                {0,1,1,1,1,1,1,1,1}
        }));
    }
}
//TODO - https://www.geeksforgeeks.org/problems/row-with-minimum-number-of-1s5430/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=row-with-max-1s