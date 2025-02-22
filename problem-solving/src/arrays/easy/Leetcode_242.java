package arrays.easy;

import java.util.HashMap;
import java.util.Map;

// Problem link = https://leetcode.com/problems/valid-anagram/description/
public class Leetcode_242 {

    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> pMap = new HashMap<>();

        for(char c : s.toCharArray()) {
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (sMap.containsKey(c)) {
                int count = sMap.get(c);
                count--;
                sMap.put(c, count);
            } else {
                sMap.put(c, sMap.getOrDefault(c, 0) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }
}
