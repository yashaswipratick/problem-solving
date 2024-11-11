package com.yashaswi.pattern.based.problems.sliding_window.fixed_size_window;

import java.util.HashSet;
import java.util.Set;

//Problem Link - https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/
public class Leetcode_1456 {

    Set<Character> set = new HashSet<>();

    public Leetcode_1456() {
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
    }

    public int maxVowels(String s, int k) {
        int count = 0;
        int maxCount = 0;
        int i = 0;
        int j = 0;


        while (j < s.length()) {
            char c = s.charAt(j);
            if (set.contains(c)) count++;
            if (j-i+1 == k) {
                maxCount = Math.max(count, maxCount);
                if (set.contains(s.charAt(i))) {
                    count--;
                }
                i++;
            }
            j++;
        }
        return maxCount;
    }
    public static void main(String[] args) {
        Leetcode_1456 lc= new Leetcode_1456();
        System.out.println(lc.maxVowels("abciiidef", 3));
        System.out.println(lc.maxVowels("aeiou", 2));
        System.out.println(lc.maxVowels("leetcode", 3));
    }
}
