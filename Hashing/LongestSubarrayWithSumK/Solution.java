package Hashing.LongestSubarrayWithSumK;
/*
 * Longest subarray with sum K
 *
 * Given an array nums of size n and an integer k, find the length of the
 * longest sub-array that sums up to k. If no such sub-array exists, return 0.
 *
 * Examples:
 *
 * Input: nums = [10, 5, 2, 7, 1, 9], k=15
 * Output: 4
 * Explanation: The longest sub-array with a sum equal to 15 is [5, 2, 7, 1],
 * which has a length of 4. This sub-array starts at index 1 and ends at index
 * 4, and the sum of its elements (5 + 2 + 7 + 1) equals 15. Therefore, the
 * length of this sub-array is 4.
 *
 * Input: nums = [-3, 2, 1], k=6
 * Output: 0
 * Explanation: There is no sub-array in the array that sums to 6. Therefore,
 * the output is 0.
 */

import java.util.HashMap;
import java.util.Map;

class Solution1 {
    // Brute Force Method
    int longestSubarray(int[] nums, int k) {
        int res = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];

                if (sum == k) {
                    int count = j - i + 1;
                    res = Math.max(res, count);
                }
            }
        }

        return res;
    }
}

class Solution {
    // Optimal Method using Prefix Sum
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;

        // Map to store the prefix sums and their first occurrence index
        Map<Integer, Integer> preSumMap = new HashMap<>();
        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            // Calculate the prefix sum till index i
            sum += nums[i];

            // If the sum equals k, update maxLen
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }

            // Calculate the remaining part (sum - k)
            int rem = sum - k;

            // Check if the remaining sum exists in the map
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            // Add the sum to the map if it's not already present
            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }

        return maxLen;
    }
}
