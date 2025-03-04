package arrays.medium;

import utility.Pair;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//Problem link - https://leetcode.com/problems/top-k-frequent-elements/
public class Leetcode_347 {

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.second));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new Pair(entry.getKey(), entry.getValue()));
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] res = new int[pq.size()];
        int i = 0;
        while (!pq.isEmpty()) {
            res[i] = pq.poll().first;
            i++;
        }
        return res;
    }

    //TODO - Implement using bucket sort

    public static void main(String[] args) {
        int[] res = topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
