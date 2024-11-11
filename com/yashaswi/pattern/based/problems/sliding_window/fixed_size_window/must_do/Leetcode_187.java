package com.yashaswi.pattern.based.problems.sliding_window.fixed_size_window.must_do;

import java.util.*;
import java.util.stream.Collectors;

//Problem Link - https://leetcode.com/problems/repeated-dna-sequences/description/
public class Leetcode_187 {

    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length() - 9; i++) {
            String substring = s.substring(i, i + 10);
            map.put(substring, map.getOrDefault(substring, 0) + 1);
        }

        return map.entrySet().stream().filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
    }

    public List<String> findRepeatedDnaSequencesOptimised(String s) {
        Set<String> set = new HashSet<>();
        List<String> res = new ArrayList<>();
        int n = s.length(), st = 0, end = 10;
        if (n < 10 || n > 10000) {
            return res;
        }

        String temp;

        while (end <= n) {
            temp = s.substring(st, end);
            if (!set.add(temp) && !res.contains(temp)) {
                res.add(temp);
            }
            st++;
            end++;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
