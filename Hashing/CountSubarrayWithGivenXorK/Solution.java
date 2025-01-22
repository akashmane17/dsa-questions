package Hashing.CountSubarrayWithGivenXorK;

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
