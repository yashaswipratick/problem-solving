package arrays.medium;

import java.util.*;

//Problem link - https://leetcode.com/problems/group-anagrams/description/
public class Leetcode_49 {

    //complexity - O(M * N * Log(M))
    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            char[] c = s.toCharArray();
            Arrays.sort(c);
            StringBuilder sb = new StringBuilder();
            for (char c1 : c) {
                sb.append(c1);
            }
            if (!map.containsKey(sb.toString())) {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(sb.toString(), list);
            } else {
                map.get(sb.toString()).add(s);
            }
        }
        return new ArrayList<>(map.values());
    }

    //Time Complexity: O(NK), where N is the length of strs, and K is the maximum length of a string in strs.
    // Counting each string is linear in the size of the string, and we count every string.
    //Space Complexity: O(NK), the total information content stored in ans.

    /**
     * Categorize by Count
     * Intuition
     *
     * Two strings are anagrams if and only if their character counts
     * (respective number of occurrences of each character) are the same.
     *
     * Algorithm
     *
     * We can transform each string s into a character count, count,
     * consisting of 26 non-negative integers representing the number of a's, b's, c's, etc.
     * We use these counts as the basis for our hash map.
     *
     * In Java, the hashable representation of our count will be a string delimited with '#' characters.
     * For example, abbccc will be #1#2#3#0#0#0...#0 where there are 26 entries total.
     * In python, the representation will be a tuple of the counts. For example, abbccc will be (1, 2, 3, 0, 0, ..., 0),
     * where again there are 26 entries total.
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagramsOptimised(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            char[] c = new char[26];
            for (char alphabetCount : s.toCharArray()) {
                c[alphabetCount - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (char key : c) {
                sb.append(key).append("#");
            }

            if (!map.containsKey(sb.toString())) {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(sb.toString(), list);
            } else {
                map.get(sb.toString()).add(s);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        System.out.println(groupAnagramsOptimised(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(groupAnagramsOptimised(new String[]{""}));
        System.out.println(groupAnagramsOptimised(new String[]{"a"}));
    }
}
