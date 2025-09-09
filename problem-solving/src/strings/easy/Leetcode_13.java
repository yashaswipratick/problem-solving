package strings.easy;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_13 {

    Map<Character, Integer> map = new HashMap<>();

    Leetcode_13() {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    /**
     * Approach:
     * - Traverse the string from left to right.
     * - For each character, compare its value with the next character.
     * - If the current value is smaller than the next, subtract it.
     * - Otherwise, add it to the result.
     * - This handles cases like IV (4), IX (9), etc., where subtraction is needed.
     */
    public int romanToInt(String s) {
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            int currentVal = map.get(s.charAt(i));

            // Check if there's a next character and it's larger than current
            if (i + 1 < s.length() && currentVal < map.get(s.charAt(i + 1))) {
                // Subtract current value if the next one is larger
                sum -= currentVal;
            } else {
                // Otherwise, just add the current value
                sum += currentVal;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Leetcode_13 lc = new Leetcode_13();
        System.out.println(lc.romanToInt("III"));
        System.out.println(lc.romanToInt("LVIII"));
        System.out.println(lc.romanToInt("MCMXCIV"));
        System.out.println(lc.romanToInt("MDCXCV"));
        System.out.println(lc.romanToInt("MMMXLV"));
    }
}
