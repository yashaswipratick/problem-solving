package strings.easy;

//Problem link - https://leetcode.com/problems/largest-odd-number-in-string/
public class Leetcode_1903 {

    //Approach

    /**
     * start from last index of string
     * check every character if it is modulus of 2 is 1 that means return the
     * substring from 0th index till the ith index +1 where you found modulus of 2 is 1.
     * @param num
     * @return
     */
    public static String largestOddNumber(String num) {
        if (num.charAt(num.length()-1) % 2 == 1) return num;

        for (int i = num.length()-1; i >= 0; i--) {
            int c = num.charAt(i);
            if (c % 2 == 1) {
                return num.substring(0, i+1);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        /*System.out.println(largestOddNumber("52"));
        System.out.println(largestOddNumber("4206"));
        System.out.println(largestOddNumber("35427"));*/
        System.out.println(largestOddNumber("6000192"));
    }
}
