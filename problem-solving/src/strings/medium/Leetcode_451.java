package strings.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode_451 {

    /**
     * Approach:
     *
     * The goal is to sort characters in the string based on their frequency in descending order.
     *
     * 1. Frequency Counting:
     *    - Use a HashMap to count how many times each character appears in the string.
     *
     * 2. Priority Queue (Max Heap):
     *    - Create a PriorityQueue (Max Heap) to store characters by their frequency in descending order.
     *    - The most frequent characters will be polled first.
     *
     * 3. Build Result:
     *    - Poll each entry from the priority queue and append its character `frequency` times to the result.
     *
     * 4. Return the final string.
     */
    public static String frequencySort(String s) {

        // Step 1: Count the frequency of each character
        // Using a HashMap to store character as key and its frequency as value
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Step 2: Use a PriorityQueue (Max Heap) to sort characters by frequency
        // We define a custom comparator to sort entries by value (frequency) in descending order
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (a,b) -> Integer.compare(b.getValue(), a.getValue()));

        // Add all character-frequency pairs to the priority queue
        pq.addAll(map.entrySet());

        // Step 3: Build the result string using the sorted characters
        // Use StringBuilder for efficient string concatenation
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> poll = pq.poll();

            // Append the character 'frequency' number of times
            sb.append(String.valueOf(poll.getKey()).repeat(poll.getValue()));
        }
        // Step 4: Return the result string
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
        System.out.println(frequencySort("cccaaa"));
        System.out.println(frequencySort("Aabb"));
    }
}
