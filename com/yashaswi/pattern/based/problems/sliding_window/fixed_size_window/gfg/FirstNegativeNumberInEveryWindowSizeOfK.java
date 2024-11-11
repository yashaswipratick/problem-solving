package com.yashaswi.pattern.based.problems.sliding_window.fixed_size_window.gfg;

import java.util.*;

//problem link = https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1
public class FirstNegativeNumberInEveryWindowSizeOfK {

    private static long[] printFirstNegativeInteger(long A[], int N, int K) {
        int i = 0;
        int j = 0;
        Queue<Long> queue = new LinkedList<>();
        List<Long> res = new ArrayList<>();

        while (j < A.length) {
            if (A[j] < 0) {
                queue.add(A[j]);
            }
            if (j-i+1 < K) {
                j++;
            } else if (j-i+1 == K) {
                res.add(queue.peek() != null ? queue.peek() : 0L);
                if (!queue.isEmpty() && A[i] == queue.peek()) {
                    queue.remove();
                }
                i++;
                j++;
            }
        }
        long[] arr = new long[res.size()];
        int k = 0;
        for (long elem : res) {
            arr[k] = elem;
            k++;
        }
        return arr;
    }

    public static void main(String[] args) {
        long[] res = printFirstNegativeInteger(new long[]{-8, 2, 3, -6, 10}, 5, 2);
        for (long i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
        long[] re1 = printFirstNegativeInteger(new long[]{12,-1,-7,8,-15,30,16,28}, 8, 3);
        for (long i : re1) {
            System.out.print(i + " ");
        }
    }
}
