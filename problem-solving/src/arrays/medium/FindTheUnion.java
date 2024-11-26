package arrays.medium;

import java.util.*;
import java.util.stream.Collectors;

//problem link - https://www.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=union-of-two-sorted-arrays
public class FindTheUnion {

    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        Set<Integer> aDistinct = new HashSet<>();

        for (int i : a) {
            aDistinct.add(i);
        }
        TreeSet<Integer> answer = new TreeSet<>(aDistinct);
        for (int i = 0; i < b.length; i++) {
            if (!aDistinct.contains(b[i])) {
                answer.add(b[i]);
            }
        }
        return new ArrayList<>(answer);
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 1, 1};
        int[] b = {2, 2, 2, 2, 2};
        System.out.println(findUnion(a, b));
    }
}
