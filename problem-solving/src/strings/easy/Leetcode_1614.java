package strings.easy;

public class Leetcode_1614 {

    /**
     * Approach:
     * - The problem asks for the **maximum nesting depth** of parentheses in a valid parentheses string.
     * - We traverse the string character by character.
     * - Maintain a `count` variable to track the current depth (increment when `(` is seen, decrement when `)` is seen).
     * - Keep updating `maxCount` to store the maximum value of `count` encountered during the traversal.
     * - At the end, `maxCount` will represent the maximum nesting depth.
     */
    public static int maxDepth(String s) {
        int count = 0;       // Current depth of parentheses
        int maxCount = 0;    // Maximum depth encountered

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;  // Increase depth for opening parenthesis
            } else if (s.charAt(i) == ')') {
                count--;  // Decrease depth for closing parenthesis
            }

            // Update max depth if current depth is greater
            maxCount = Math.max(count, maxCount);
        }

        return maxCount;
    }

    public static void main(String[] args) {
        System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));
        System.out.println(maxDepth("(1)+((2))+(((3)))"));
        System.out.println(maxDepth("()(())((()()))"));
    }
}
