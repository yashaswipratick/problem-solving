package strings.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Problem lik - https://leetcode.com/problems/isomorphic-strings/
// Reference - https://www.youtube.com/watch?v=ogTMIFPjNkQ
public class Leetcode_205 {

    /**
     * Approach
     *1. Character Mapping using a HashMap
     * A Map<Character, Character> is used to store the mapping from characters in s to characters in t.
     * 2. One-to-One Mapping Enforcement
     * If a character from s hasn't been mapped before:
     * Check if the target character in t is already mapped to someone else (map.containsValue()).
     * If yes, return false (violates one-to-one mapping).
     * Else, create the mapping.
     * If the character in s is already mapped:
     * Validate that the mapped character is the current one from t.
     * If not, return false.
     * 3. Full Pass Validation
     * Loop through both strings character by character (they are guaranteed to be the same length).
     * If all mappings are valid, return true
     *
     * Time Complexity: O(n^2)
     * Due to the map.containsValue() call inside the loop, which takes O(n) time in the worst case.
     * @param s
     * @param t
     * @return
     */
    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char original = s.charAt(i);
            char replacement = t.charAt(i);

            if (!map.containsKey(original)) {
                if (!map.containsValue(replacement)) {
                    map.put(original, replacement);
                } else {
                    return false;
                }
            } else {
                char c = map.get(original);
                if (c != replacement) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Approach
     *
     * Initialize Two HashMaps
     *
     * sMap: maps characters from s → t
     * tMap: maps characters from t → s
     * ✅ This double-mapping ensures bijective (two-way) mapping.
     * Iterate Over Characters For each index i:
     *
     * Extract s.charAt(i) → original
     * Extract t.charAt(i) → replacement
     * Check & Build Mappings
     *
     * If original not in sMap:
     * Check if replacement already exists in tMap
     * If yes → mapping is invalid → return false
     * If no → add mappings in both sMap and tMap
     * If original is already mapped, verify:
     * It must match the current replacement
     * Else → mismatch → return false
     * All characters matched correctly → return true
     *
     *
     * Time & Space Complexity
     * Time Complexity: O(n)
     * Efficient one-pass over the string (no nested loops).
     * Space Complexity: O(n)
     * In the worst case, all unique characters are stored in the maps.
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isIsomorphicTwoHashMap(String s, String t) {
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char original = s.charAt(i);
            char replacement = t.charAt(i);

            if (!sMap.containsKey(original)) {
                if (!tMap.containsKey(replacement)) {
                    sMap.put(original, replacement);
                    tMap.put(replacement, original);
                } else {
                    return false;
                }
            } else {
                char c = sMap.get(original);
                if (c != replacement) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphicTwoHashMap("egg", "add"));
        System.out.println(isIsomorphicTwoHashMap("foo", "bar"));
        System.out.println(isIsomorphicTwoHashMap("bbbaaaba", "aaabbbba"));
    }
}
