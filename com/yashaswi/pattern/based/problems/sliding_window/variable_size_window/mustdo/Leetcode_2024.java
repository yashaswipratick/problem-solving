package com.yashaswi.pattern.based.problems.sliding_window.variable_size_window.mustdo;

// Problem link - https://leetcode.com/problems/maximize-the-confusion-of-an-exam/description/
public class Leetcode_2024 {

    //    answerKey = "FTFTFTF"
    //    k = 3
    public static int maxConsecutiveAnswers(String answerKey, int k) {
        int maxT = maxConsecutiveChars(answerKey, k, 'T');  // Maximize consecutive 'T's
        int maxF = maxConsecutiveChars(answerKey, k, 'F');  // Maximize consecutive 'F's
        return Math.max(maxT, maxF);  // Return the maximum result from both
    }

    private static int maxConsecutiveChars(String answerKey, int k, char target) {
        int start = 0;
        int maxCount = 0;
        int count = 0;  // Tracks changes made

        for (int end = 0; end < answerKey.length(); end++) { //TTFTTFTT
            // Count occurrences that are not the target, as we may change them
            if (answerKey.charAt(end) != target) {
                count++;
            }

            // If count exceeds k, adjust start to reduce count within window
            while (count > k) {
                if (answerKey.charAt(start) != target) {
                    count--;
                }
                start++;
            }

            // Calculate the length of the current valid window
            maxCount = Math.max(maxCount, end - start + 1);
        }

        return maxCount;
    }

    public static void main(String[] args) {
        System.out.println(maxConsecutiveAnswers("FTFTFTF", 3));
        System.out.println(maxConsecutiveAnswers("TFFT", 1));
        System.out.println(maxConsecutiveAnswers("TTFF", 2));
        System.out.println(maxConsecutiveAnswers("TTFTTFTT", 1));
    }
}

/**
 * chat gpt help
 * Initialize two pointers, start and end, both at the start of the string. Use a counter to track the number of 'F's in the current window.
 *
 * Expand the window by moving end to the right, one character at a time. If the count of 'F's exceeds k, move the start pointer to the right to reduce the number of 'F's until we’re back within the k limit.
 *
 * Detailed Walkthrough:
 *
 * Window [0:0] ("T"):
 *
 * Count of 'F's = 0 (within k=1)
 * Current length of consecutive 'T's = 1
 * Window [0:1] ("TT"):
 *
 * Count of 'F's = 0 (within k=1)
 * Current length = 2
 * Window [0:2] ("TTF"):
 *
 * Count of 'F's = 1 (within k=1)
 * Current length = 3
 * Window [0:3] ("TTFT"):
 *
 * Count of 'F's = 1 (within k=1)
 * Current length = 4
 * Window [0:4] ("TTFTT"):
 *
 * Count of 'F's = 1 (within k=1)
 * Current length = 5
 * Window [0:5] ("TTFTTF"):
 *
 * Count of 'F's = 2, which exceeds k=1.
 *
 * To bring the 'F' count back within k=1, move start to 1. The window becomes "TFTTF".
 *
 * Count of 'F's = 2 (still exceeds k=1).
 * Move start to 2. Now the window becomes "FTTF".
 *
 * Count of 'F's = 2 (still exceeds k=1).
 * Move start to 3. The window becomes "TTF".
 *
 * Count of 'F's = 1 (now within k=1).
 * Window length is now 3 (from index 3 to 5).
 * Window [3:6] ("TTFT"):
 *
 * Count of 'F's = 1 (within k=1)
 * Current length = 4
 * Window [3:7] ("TTFTT"):
 *
 * Count of 'F's = 1 (within k=1)
 * Current length = 5
 * After expanding the entire window, the maximum consecutive 'T's length is 5 (achieved with "TTFTT" by changing one 'F' to 'T').
 *
 * Part 2: Maximize Consecutive 'F's
 * Using a similar approach, we would find the maximum consecutive 'F's by flipping 'T's to 'F'. However, the longest sequence we can achieve here is less than 5.
 *
 * Conclusion
 * The longest possible sequence of consecutive identical characters is 5 'T's, so the answer is 5.
 */
