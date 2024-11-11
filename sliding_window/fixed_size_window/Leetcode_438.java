package sliding_window.fixed_size_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//problem Link - https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
public class Leetcode_438 {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> mapP = new HashMap<>();
        Map<Character, Integer> mapS = new HashMap<>();
        int K = p.length();

        for (char c : p.toCharArray()) {
            mapP.put(c, mapP.getOrDefault(c, 0) + 1);
        }

        int i = 0;
        int j = 0;

        while (j < s.length()) {
            char jChar = s.charAt(j);
            mapS.put(jChar, mapS.getOrDefault(jChar, 0) + 1);

            if (j - i + 1 < K) {
                j++;
            } else if (j - i + 1 == K) {
                //check if anagram
                if (checkIfAnagram(mapS, mapP)) {
                    list.add(i);
                }
                char iChar = s.charAt(i);
                //remove character or character count from mapS
                if (mapS.get(iChar) > 1) {
                    mapS.put(iChar, mapS.get(iChar) - 1);
                } else {
                    mapS.remove(iChar);
                }
                //increament i
                i++;
                //increament j;
                j++;
            }
        }
        return list;
    }

    private static boolean checkIfAnagram(Map<Character, Integer> mapS, Map<Character, Integer> mapP) {

        for (Character character : mapP.keySet()) {
            if (!mapS.containsKey(character)
                    || (mapS.containsKey(character)
                    && !mapS.get(character).equals(mapP.get(character)))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        /*System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("abab", "ab"));*/
        System.out.println(findAnagrams("baa", "aa"));
    }
}

/**
 * class Solution {
 *
 *     //TC - O(n)
 *     public List<Integer> findAnagrams(String s, String p) {
 *         int ns = s.length(), np = p.length();
 *         if (ns < np) return new ArrayList();
 *
 *         Map<Character, Integer> pCount = new HashMap<>();
 *         for (char c : p.toCharArray()) {
 *             pCount.put(c, pCount.getOrDefault(c, 0) + 1);
 *         }
 *
 *         Map<Character, Integer> sCount = new HashMap<>();
 *
 *         List<Integer> output = new ArrayList<>();
 *
 *         // sliding window on the string s
 *     for (int i = 0; i < ns; ++i) {
 *       // add one more letter
 *       // on the right side of the window
 *       char ch = s.charAt(i);
 *       if (sCount.containsKey(ch)) {
 *         sCount.put(ch, sCount.get(ch) + 1);
 *       }
 *       else {
 *         sCount.put(ch, 1);
 *       }
 *       // remove one letter
 *       // from the left side of the window
 *       if (i >= np) {
 *         ch = s.charAt(i - np);
 *         if (sCount.get(ch) == 1) {
 *           sCount.remove(ch);
 *         }
 *         else {
 *           sCount.put(ch, sCount.get(ch) - 1);
 *         }
 *       }
 *       // compare hashmap in the sliding window
 *       // with the reference hashmap
 *       if (pCount.equals(sCount)) {
 *         output.add(i - np + 1);
 *       }
 *     }
 *     return output;
 *     }
 *
 *     //TC - O(s*p)
 *     public List<Integer> findAnagramsApproachOne(String s, String p) {
 *         Map<Character, Integer> anagram = new HashMap<>();
 *         for (char c : p.toCharArray()) {
 *             anagram.put(c, anagram.getOrDefault(c, 0) + 1);
 *         }
 *
 *         List<Integer> index = new ArrayList<>();
 *         for (int i = 0; i < s.length()-p.length()+1; i++) {
 *             String substring = s.substring(i, p.length()+i);
 *             if (checkIfAnagram(substring, anagram)) {
 *                 index.add(i);
 *             }
 *         }
 *         return index;
 *     }
 *
 *     private static boolean checkIfAnagram(String substring, Map<Character, Integer> anagram) {
 *         Map<Character, Integer> map = new HashMap<>();
 *         for (char c : substring.toCharArray()) {
 *             map.put(c, map.getOrDefault(c, 0) + 1);
 *         }
 *
 *         for (Character character : map.keySet()) {
 *             if (anagram.containsKey(character) && anagram.get(character).equals(map.get(character))){
 *                 continue;
 *             } else {
 *                 return false;
 *             }
 *         }
 *         return true;
 *     }
 * }
 */
