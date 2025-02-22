package arrays.easy;

public class Leetcode_14 {
    /**
     * Approach
     * take the first index as prefix.
     * start for loop with 1st index
     * if at i the string starts with prefix then break the inner loop
     * if at i the string does not starts with prefix then remove the last character from prefix
     * until the string at i starts with prefix
     * continue for all the index if the value matched then return the prefix else return empty
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (true) {
                if (strs[i].startsWith(prefix)) {
                    break;
                } else if (prefix.length() > 1) {
                    prefix = prefix.substring(0, prefix.length()-1);
                } else {
                    prefix = "";
                    break;
                }
            }
            if (prefix.length() == 0) {
                break;
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
