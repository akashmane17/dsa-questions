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
    public int subarraySum(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }
}

class Solution {
    // Optimal Method using Prefix Sum
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;

        // Using HashMap to store prefix sums and their frequencies
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Initialize the map with sum 0 and frequency 1

        for (int num : nums) {
            // Add current number to the prefix sum
            sum += num;

            // Calculate the remainder (sum - k)
            int rem = sum - k;

            // If the remainder exists in the map, add its frequency to the count
            count += map.getOrDefault(rem, 0);

            // Update the frequency of the current prefix sum in the map
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
