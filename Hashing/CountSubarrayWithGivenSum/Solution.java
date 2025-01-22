package Hashing.CountSubarrayWithGivenSum;

import java.util.HashMap;
import java.util.Map;

class Solution {
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

class Solution2 {
    // Optimal Method using Prefix Sum and HashMap
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;

        // HashMap to store prefix sums and their frequencies
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Initialize map with sum 0 and frequency 1

        for (int num : nums) {
            // Add the current number to the prefix sum
            sum += num;

            // Calculate the value to remove (sum - k)
            int rem = sum - k;

            // If rem exists in the map, add its frequency to count
            count += map.getOrDefault(rem, 0);

            // Update the frequency of the current prefix sum in the map
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}