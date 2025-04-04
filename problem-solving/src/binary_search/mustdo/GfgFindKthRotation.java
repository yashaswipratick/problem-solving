package binary_search.mustdo;

import java.util.Arrays;
import java.util.List;

//Problem link - https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class GfgFindKthRotation {

    public static int findKRotation(List<Integer> arr) {
        int start = 0;
        int end = arr.size() - 1;
        int target = Integer.MIN_VALUE;
        int targetIndex = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr.get(start) <= arr.get(mid)) { // check if left half is sorted, then takes the min which is arr.get(start) and eliminate left half
                target = Math.max(target, arr.get(mid));
                targetIndex = target > arr.get(mid) ? targetIndex : mid;
                start = mid + 1;
            } else { // check if right half is sorted, then takes the min which is arr.get(mid) and eliminate right half
                target = Math.max(target, arr.get(end));
                targetIndex = target > arr.get(mid) ? targetIndex : mid;
                end = mid - 1;
            }

        }
        targetIndex += 1;
        if (targetIndex == arr.size()) {
            return 0;
        } else {
            return targetIndex;
        }
    }

    public static void main(String[] args) {
        System.out.println(findKRotation(Arrays.asList(3, 4, 5, 1, 2)));
        System.out.println(findKRotation(Arrays.asList(2,3,4,5,1)));
        System.out.println(findKRotation(Arrays.asList(5,1,2,3)));
        System.out.println(findKRotation(Arrays.asList(1,2,3,4,5)));
        System.out.println(findKRotation(Arrays.asList(1)));

        System.out.println(findKRotation(Arrays.asList(5,1,2,3,4))); // special case
    }
}
