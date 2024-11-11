package sliding_window.fixed_size_window;

import java.util.HashMap;
import java.util.Map;

//Problem Link - https://leetcode.com/problems/permutation-in-string/description/
public class Leetcode_567 {

    public static boolean checkInclusion(String s1, String s2) {
        int i = 0;
        int j = 0;

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (char c : s1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        int k = s1.length();
        while (j < s2.length()) {
            char c = s2.charAt(j);
            map2.put(c, map2.getOrDefault(c, 0) + 1);

            if (j-i+1 == k) {
                boolean b = checkFrequency(map1, map2);
                if (b) {
                    return true;
                } else {
                    char c1 = s2.charAt(i);
                    if (map2.get(c1) <= 1) {
                        map2.remove(c1);
                    } else {
                        map2.put(c1, map2.get(c1) - 1);
                    }
                }
                i++;
            }
            j++;
        }
        return false;
    }

    private static boolean checkFrequency(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2) {
        boolean flag = false;
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            if (map2.containsKey(entry.getKey()) && map2.get(entry.getKey()) == entry.getValue()) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("ab", "eidboaooo"));
        System.out.println(checkInclusion("abcdxabcde", "abcdeabcdx"));
    }
}
