package com.yashaswi.pattern.based.problems.sliding_window.fixed_size_window;

//Problem Link - https://leetcode.com/problems/find-k-length-substrings-with-no-repeated-characters/description/
public class Leetcode_1100 {

    public static int numKLenSubstrNoRepeats(String s, int k) {
        if (k > s.length()) return 0;

        int[] charCount = new int[26];
        int count = 0, uniqueChars = 0;
        int i = 0, j = 0;

        while (j < s.length()) {
            char endChar = s.charAt(j);
            charCount[endChar - 'a']++;
            if (charCount[endChar - 'a'] == 1) {
                uniqueChars++;
            }

            if (j - i + 1 > k) {
                char startChar = s.charAt(i);
                if (charCount[startChar - 'a'] == 1) {
                    uniqueChars--;
                }
                charCount[startChar - 'a']--;
                i++;
            }

            if (j - i + 1 == k && uniqueChars == k) {
                count++;
            }

            j++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numKLenSubstrNoRepeats("havefunonleetcode", 5));
        System.out.println(numKLenSubstrNoRepeats("home", 5));
    }
}
