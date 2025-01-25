package Hashing.CountSubarrayWithGivenXorK;

/*
Count subarrays with given xor K
Given an array of integers nums and an integer k, return the total number of subarrays whose XOR equals to k.

Examples:
Input : nums = [4, 2, 2, 6, 4], k = 6
Output : 4
Explanation : The subarrays having XOR of their elements as 6 are [4, 2],  [4, 2, 2, 6, 4], [2, 2, 6], and [6]

Input :nums = [5, 6, 7, 8, 9], k = 5
Output : 2
Explanation : The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9]F
*/

// Brute Force

import java.util.HashMap;
import java.util.Map;

class Solution {
    // Brute Force Method
    public int subarraysWithXorK(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int xorr = 0;

            for (int j = i; j < n; j++) {
                xorr ^= nums[j];

                if (xorr == k) {
                    count++;
                }
            }
        }

        return count;
    }
}

class Solution2 {
    // Optimal Method using Prefix XOR and HashMap
    public int subarraysWithXorK(int[] nums, int k) {
        int xr = 0;
        int count = 0;

        // Map to store prefix XOR frequencies
        Map<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0, 1); // Initialize with XOR 0 having frequency 1

        for (int num : nums) {
            // Calculate prefix XOR till current index
            xr ^= num;

            // By formula: x = xr ^ k
            int x = xr ^ k;

            // Add occurrences of xr ^ k to the count
            count += mpp.getOrDefault(x, 0);

            // Insert the current prefix XOR into the map
            mpp.put(xr, mpp.getOrDefault(xr, 0) + 1);
        }

        return count;
    }
}
