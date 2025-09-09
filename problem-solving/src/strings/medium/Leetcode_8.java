package strings.medium;

//Problem link - https://leetcode.com/problems/string-to-integer-atoi/description/
public class Leetcode_8 {

    /**
     * Approach:
     *
     * 1. Skip Leading Whitespaces
     *    - Start from the beginning and skip all the spaces.
     *
     * 2. Handle Optional '+' or '-' Sign
     *    - If the next character is '+' or '-', record the sign.
     *
     * 3. Read Digits
     *    - Traverse through the string and keep building the number using digits.
     *    - Stop when a non-digit is found.
     *
     * 4. Clamp the Value
     *    - If the number goes beyond Integer.MAX_VALUE or below Integer.MIN_VALUE,
     *      clamp it to the respective limit.
     *
     * 5. Return the Result with Proper Sign
     */
    public static int myAtoi(String s) {
        // Step 1: Skip leading whitespaces
        int i = 0;
        int n = s.length();
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Step 2: Handle optional sign
        int sign = 1;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }

        // Step 3: Read digits and build the number
        long num = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {

            // Convert the current digit character to its integer value (e.g., '3' -> 3)
            // and update the number by shifting previous digits left (multiply by 10)
            // and adding the new digit to the right.
            num = num * 10 + (s.charAt(i) - '0');

            // Step 4: Clamp the result to fit in 32-bit signed int
            if (sign == 1 && num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == -1 && -num < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            i++;
        }

        // Step 5: Return the final result with sign
        return (int)(sign * num);
    }


    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi(" -42"));
        System.out.println(myAtoi("1337c0d3"));
        System.out.println(myAtoi("0-1"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("1002"));
    }
}
