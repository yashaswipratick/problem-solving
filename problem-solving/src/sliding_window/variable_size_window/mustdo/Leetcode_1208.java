package sliding_window.variable_size_window.mustdo;

public class Leetcode_1208 {

    public static int equalSubstring(String s, String t, int maxCost) {
        int i = 0;
        int windowSum = 0;
        int maxWindowSize = 0;

        for (int j = 0; j < s.length(); j++) {
            windowSum += cost(s, t, j);

            while (windowSum > maxCost) {
                windowSum -= cost(s, t, i);
                i++;
            }
            maxWindowSize = Math.max(maxWindowSize, j-i+1);
        }

        return maxWindowSize;
    }

    private static int cost(String s, String t, int i) {
        return Math.abs(s.charAt(i) - t.charAt(i));
    }

    public static void main(String[] args) {
        System.out.println(equalSubstring("abcd", "bcdf", 3));
        System.out.println(equalSubstring("abcd", "cdef", 3));
    }
}
