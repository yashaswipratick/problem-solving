package sliding_window.variable_size_window.mustdo;

import java.util.HashMap;

public class Leetcode_3 {

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int l = 0;
        int r = 0;

        int maxCount = 0;

        while (r < s.length()) {
            char c = s.charAt(r);
            if (map.containsKey(c)) {
                l = Math.max(map.get(c) + 1, l);
            }
            map.put(c, r);
            maxCount = Math.max(maxCount, r - l + 1);
            r++;
        }
        return maxCount;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
