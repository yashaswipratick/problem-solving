# Sorting Algorithms

A list of common **sorting algorithms**, categorized by their **time complexity** and **sorting strategy**.

---

## 📌 1. Comparison-Based Sorting Algorithms
These algorithms compare elements to determine their order.

### 🔹 A. O(n²) - Quadratic Time (Brute Force)
Used for small datasets due to their inefficiency on large data.

```plaintext
Algorithm      | Best Case  | Average Case | Worst Case | Stable? | In-Place?
-------------- | ----------|------------- |------------ |-------- |---------
Bubble Sort    | O(n)      | O(n²)        | O(n²)      | ✅ Yes  | ✅ Yes
Selection Sort | O(n²)     | O(n²)        | O(n²)      | ❌ No   | ✅ Yes
Insertion Sort | O(n)      | O(n²)        | O(n²)      | ✅ Yes  | ✅ Yes
```

---

### 🔹 B. O(n log n) - Efficient Sorting (Divide & Conquer)
Used for large datasets as they scale better.

```plaintext
Algorithm      | Best Case  | Average Case | Worst Case | Stable? | In-Place?
-------------- | ----------|------------- |------------ |-------- |---------
Merge Sort     | O(n log n)| O(n log n)   | O(n log n) | ✅ Yes  | ❌ No
Quick Sort     | O(n log n)| O(n log n)   | O(n²)      | ❌ No   | ✅ Yes
Heap Sort      | O(n log n)| O(n log n)   | O(n log n) | ❌ No   | ✅ Yes
```

---

## 📌 2. Non-Comparison Sorting Algorithms (Faster than O(n log n))
These work by distributing elements into buckets instead of direct comparisons.

```plaintext
Algorithm       | Best Case  | Average Case | Worst Case | Stable? | In-Place? | Notes
--------------- | ----------|------------- |------------ |-------- |---------  |------
Counting Sort   | O(n+k)    | O(n+k)       | O(n+k)     | ✅ Yes  | ❌ No     | Only for integers
Radix Sort      | O(nk)     | O(nk)        | O(nk)      | ✅ Yes  | ❌ No     | Works well with integers and strings
Bucket Sort     | O(n+k)    | O(n)         | O(n²)      | ✅ Yes  | ❌ No     | Best when input is uniformly distributed
```

---

## 📌 3. Hybrid Sorting Algorithms
These combine multiple strategies to optimize sorting.

```plaintext
Algorithm   | Best Case  | Average Case | Worst Case | Stable? | Notes
----------- | ----------|------------- |------------ |-------- |------
Timsort     | O(n)      | O(n log n)   | O(n log n) | ✅ Yes  | Used in Python & Java’s built-in sorting
Introsort   | O(n log n)| O(n log n)   | O(n log n) | ❌ No   | Mix of QuickSort, HeapSort, and Insertion Sort
```

---

## 📌 Which Sorting Algorithm Should You Use?
✅ **For small datasets (n < 50):**
- **Insertion Sort** (if nearly sorted)
- **Selection Sort** (if memory is a concern)

✅ **For general sorting:**
- **Merge Sort** (when stability is needed)
- **QuickSort** (for speed and in-place sorting)
- **Heap Sort** (when worst-case guarantee is needed)

✅ **For large numbers and integers:**
- **Counting Sort** / **Radix Sort** (when range is small)

✅ **For real-world applications:**
- **Timsort** (used in Python, Java, Android)
- **Introsort** (used in C++ STL sort)




# Sliding Window Problems

## Fixed Size Window Pattern Problems

- [Max Sum Subarray of Size K (GeeksforGeeks)](https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1)
- [First Negative Integer in Every Window of Size K (GeeksforGeeks)](https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1)
- [Maximum Sum of Distinct Subarrays with Length K](https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/)
- [Sliding Subarray Beauty](https://leetcode.com/problems/sliding-subarray-beauty/)
- [Maximum Points You Can Obtain from Cards](https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/)
- [Maximum Average Subarray I](https://leetcode.com/problems/maximum-average-subarray-i/)
- [Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold](https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/)
- [Check if a String Contains All Binary Codes of Size K](https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/)
- [Find All Anagrams in a String](https://leetcode.com/problems/find-all-anagrams-in-a-string/)
- [Permutation in String](https://leetcode.com/problems/permutation-in-string/)
- [Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/)
- [Substrings of Size Three with Distinct Characters](https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/)
- [Substring with Concatenation of All Words](https://leetcode.com/problems/substring-with-concatenation-of-all-words/)
- [Repeated DNA Sequences](https://leetcode.com/problems/repeated-dna-sequences/)
- [Maximum Average Subarray I](https://leetcode.com/problems/maximum-average-subarray-i/)
- [Minimum Number of K Consecutive Bit Flips](https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/)
- [Find K-Length Substrings With No Repeated Characters](https://leetcode.com/problems/find-k-length-substrings-with-no-repeated-characters/)
- [Minimum Swaps to Group All 1's Together](https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together/)
- [Diet Plan Performance](https://leetcode.com/problems/diet-plan-performance/)
- [Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold](https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/)
- [Maximum Points You Can Obtain from Cards](https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/)
- [Maximum Number of Vowels in a Substring of Given Length](https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/)
- [Defuse the Bomb](https://leetcode.com/problems/defuse-the-bomb/)
- [Substrings of Size Three with Distinct Characters](https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/)
- [K Radius Subarray Averages](https://leetcode.com/problems/k-radius-subarray-averages/)
- [Minimum Swaps to Group All 1's Together II](https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii/)
- [Find the K-Beauty of a Number](https://leetcode.com/problems/find-the-k-beauty-of-a-number/)
- [Minimum Recolors to Get K Consecutive Black Blocks](https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/)
- [Distinct Numbers in Each Subarray](https://leetcode.com/problems/distinct-numbers-in-each-subarray/)

## Variable Size Window Pattern Problems

- [Find the Longest Semi-Repetitive Substring](https://leetcode.com/problems/find-the-longest-semi-repetitive-substring/)
- [Count the Number of Good Subarrays](https://leetcode.com/problems/count-the-number-of-good-subarrays/)
- [Minimum Consecutive Cards to Pick Up](https://leetcode.com/problems/minimum-consecutive-cards-to-pick-up/)
- [Minimum Operations to Reduce X to Zero](https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/)
- [Count Number of Nice Subarrays](https://leetcode.com/problems/count-number-of-nice-subarrays/)
- [Fruit Into Baskets](https://leetcode.com/problems/fruit-into-baskets/)
- [Max Consecutive Ones III](https://leetcode.com/problems/max-consecutive-ones-iii/)
- [Subarray Product Less Than K](https://leetcode.com/problems/subarray-product-less-than-k/)
- [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)
- [Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/)
- [Longest Substring with At Most Two Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/)
- [Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/)
- [Longest Substring with At Most K Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/)
- [Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/)
- [Max Consecutive Ones II](https://leetcode.com/problems/max-consecutive-ones-ii/)
- [Number of Subarrays with Bounded Maximum](https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/)
- [Subarrays with K Different Integers](https://leetcode.com/problems/subarrays-with-k-different-integers/)
- [Max Consecutive Ones III](https://leetcode.com/problems/max-consecutive-ones-iii/)
- [Get Equal Substrings Within Budget](https://leetcode.com/problems/get-equal-substrings-within-budget/)
- [Maximum Number of Occurrences of a Substring](https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/)
- [Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit](https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/)
- [Longest Subarray of 1's After Deleting One Element](https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/)
- [Maximum Erasure Value](https://leetcode.com/problems/maximum-erasure-value/)
- [Frequency of the Most Frequent Element](https://leetcode.com/problems/frequency-of-the-most-frequent-element/)
- [Maximize the Confusion of an Exam](https://leetcode.com/problems/maximize-the-confusion-of-an-exam/)
- [Count Vowel Substrings of a String](https://leetcode.com/problems/count-vowel-substrings-of-a-string/)

