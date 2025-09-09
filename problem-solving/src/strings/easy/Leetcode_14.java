package strings.easy;

public class Leetcode_14 {
    /**
     * Approach:
     * Check Edge Cases
     *
     * If the input array strs is null or empty, return "" immediately.
     * Initialize Prefix
     *
     * Assume the first string (strs[0]) as the initial prefix.
     * Iterate Through the Array
     *
     * Start iterating from the second string (strs[1] onwards).
     * Compare each string with the current prefix.
     * Shorten the Prefix If Needed
     *
     * If the current string does not start with the prefix, repeatedly shorten the prefix (remove the last character) until a match is found.
     * If the prefix becomes empty at any point, return "" immediately since there's no common prefix.
     * Return the Longest Common Prefix
     *
     * After iterating through all strings, return the prefix.
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return ""; // Edge case

        String prefix = strs[0]; // Assume first string as prefix

        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1); // Reduce prefix length
                if (prefix.isEmpty()) return ""; // If prefix becomes empty, return immediately
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] strs1 = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs1));
        String[] strs2 = {"zebra", "zoo", "zip"};
        System.out.println(longestCommonPrefix(strs2));
        String[] strs3 = {"single"};
        System.out.println(longestCommonPrefix(strs3));
        String[] strs4 = {"", "hello", "hi"};
        System.out.println(longestCommonPrefix(strs4));
        String[] strs5 = {"hello", "world", "python"};
        System.out.println(longestCommonPrefix(strs5));
    }
}
