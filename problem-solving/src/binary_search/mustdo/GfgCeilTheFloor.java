package binary_search.mustdo;

//problem link - https://www.geeksforgeeks.org/problems/ceil-the-floor2802/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=ceil-the-floor
public class GfgCeilTheFloor {

    public static int[] getFloorAndCeil(int x, int[] arr) {
        int floor = Integer.MIN_VALUE;
        int ceil = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= x && arr[i] >= floor) {
                floor = arr[i];
            }

            if (arr[i] >= x && arr[i] <= ceil) {
                ceil = arr[i];
            }
        }
        int[] res = new int[2];
        res[0] = floor != Integer.MIN_VALUE ? floor : -1;
        res[1] = ceil != Integer.MAX_VALUE ? ceil : -1;
        return res;
    }

    public static void main(String[] args) {
        int[] floorAndCeil = getFloorAndCeil(7, new int[]{5, 6, 8, 9, 6, 5, 5, 6});
        System.out.println(floorAndCeil[0]);
        System.out.println(floorAndCeil[1]);

        int[] floorAndCeil1 = getFloorAndCeil(10, new int[]{5, 6, 8, 8, 6, 5, 5, 6});
        System.out.println(floorAndCeil1[0]);
        System.out.println(floorAndCeil1[1]);

        int[] floorAndCeil2 = getFloorAndCeil(17, new int[]{36,82,88,56,21,17,73,86});
        System.out.println(floorAndCeil2[0]);
        System.out.println(floorAndCeil2[1]);
    }
}
