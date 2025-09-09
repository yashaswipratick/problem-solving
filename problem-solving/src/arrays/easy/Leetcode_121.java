package arrays.easy;

public class Leetcode_121 {

    /*
        Approach:

        💡 Goal: Find the maximum profit from a single buy and sell operation.

        1. Start by assuming the first day's price is the minimum buying price.

        2. Traverse through the array from the second element:
           - For each day's price:
             - Update the buyingPrice if the current price is lower (i.e., we found a cheaper day to buy).
             - Calculate the profit by selling at the current price and buying at the minimum seen so far.
             - Update the maximum profit if this new profit is higher than the previous one.

        3. At the end, return the maximum profit we’ve found.

        ✅ Key idea: We always keep track of the lowest price to buy and calculate the best profit on each day.
        This ensures we get the highest possible single-transaction profit.
*/

    public static int maxProfit(int[] prices) {
        int buyingPrice = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            buyingPrice = Math.min(buyingPrice, prices[i]);
            profit = Math.max(profit, prices[i] - buyingPrice);
        }
        return Math.max(profit, 0);
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }
}
