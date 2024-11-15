package sliding_window.variable_size_window.mustdo;

public class Leetcode_2730 {

    public static int longestSemiRepetitiveSubstring(String s) {
        if (s.length() == 1) {
            return 1;
        }
        int i = 0;
        int repeated_pairs = 0;
        int max_repeated_pairs = 0;

        for (int j = 1; j < s.length(); j++) {
            if (s.charAt(j) == s.charAt(j-1)) {
                repeated_pairs += 1;
            }

            while (repeated_pairs > 1) {
                if (s.charAt(i) == s.charAt(i+1)) {
                    repeated_pairs -= 1;
                }
                i++;
            }
            max_repeated_pairs = Math.max(max_repeated_pairs, j-i+1);
        }
        return max_repeated_pairs;
    }

    public static void main(String[] args) {
        System.out.println(longestSemiRepetitiveSubstring("52233"));
        System.out.println(longestSemiRepetitiveSubstring("5494"));
        System.out.println(longestSemiRepetitiveSubstring("1111111"));
    }
}

/**
 * Approach and Hints
 * Here’s how you might think about solving this:
 *
 * Sliding Window Technique:
 *
 * Use a sliding window to check all possible substrings of s.
 * Keep expanding the window until there are more than one pair of adjacent same digits.
 * When you encounter a second pair of repeated digits, move the window start forward to try and reduce it to one pair.
 * Counting Pairs:
 *
 * Use a counter to track pairs of repeated digits within the current window.
 * If you encounter a second repeated pair in the window, shift the start position to shorten the window until there’s only one pair left.
 * Update the Maximum Length:
 *
 * Each time you have a valid window (with at most one pair of adjacent repeated digits), calculate the window length.
 * Track the maximum length across all valid windows.
 * Edge Cases:
 *
 * If the entire string has no repeated adjacent digits, then the answer is simply the length of s.
 * If the string has only one character, the answer is 1 by default.
 */
