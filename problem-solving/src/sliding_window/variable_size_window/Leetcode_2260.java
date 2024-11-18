package sliding_window.variable_size_window;

import java.util.*;

public class Leetcode_2260 {

    public static int minimumCardPickup(int[] cards) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < cards.length; i++) {
            if (!map.containsKey(cards[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(cards[i], list);
            } else {
                List<Integer> list = map.get(cards[i]);
                Integer lastIndex = list.get(list.size() - 1);
                minLength = Math.min(minLength, i-lastIndex+1);
                list.add(i);
                map.put(cards[i], list);
            }
        }
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    public static int minimumCardSlidingWindow(int[] cards) {
        // sliding window and hashmap

        Set<Integer> seen = new HashSet<>();

        int left = 0;
        int ans = cards.length + 1;
        for (int right = 0; right < cards.length; right++) {
            while (seen.contains(cards[right])) {
                ans = Math.min(ans, right - left + 1);
                seen.remove(cards[left]);
                left++;
            }

            seen.add(cards[right]);
        }


        return ans == cards.length + 1 ? -1 : ans;
    }

    public static void main(String[] args) {
        System.out.println(minimumCardSlidingWindow(new int[]{3, 4, 2, 3, 4, 7}));
        System.out.println(minimumCardSlidingWindow(new int[]{1,0,5,3}));
        System.out.println(minimumCardSlidingWindow(new int[]{3,4,9,2,3,4,8,7,8,9,8}));
        System.out.println(minimumCardSlidingWindow(new int[]{1,1,1,1,1}));
    }
}
