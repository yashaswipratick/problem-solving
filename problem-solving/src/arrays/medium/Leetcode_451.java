package arrays.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//Problem link - https://leetcode.com/problems/sort-characters-by-frequency/
public class Leetcode_451 {

    public static String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Max-Heap (PriorityQueue) to sort characters by frequency in descending order
        PriorityQueue<Map.Entry<Character, Integer>> pq =
                new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));

        // Add all entries (character, frequency) to the priority queue
        pq.addAll(map.entrySet());

        // Build the sorted string
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();
            sb.append(String.valueOf(entry.getKey()).repeat(entry.getValue())); // Java 11+ feature
        }
        return sb.toString();
    }

    //TODO - do it in O(n) time complexities
    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
        System.out.println(frequencySort("cccaaa"));
        System.out.println(frequencySort("Aabb"));
    }
}
