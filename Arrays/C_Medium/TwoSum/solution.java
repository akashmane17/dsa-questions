package Arrays.C_Medium.TwoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target. Return the indices(0 -
 * indexed) of two elements in nums such that they add up to target.
 * Each input will have exactly one solution, and the same element cannot be
 * used twice. Return the answer in non-decreasing order.
 * 
 * Example 1
 * Input: nums = [1, 6, 2, 10, 3], target = 7
 * Output: [0, 1]
 * Explanation: nums[0] + nums[1] = 1 + 6 = 7
 * 
 * Example 2
 * Input: nums = [1, 3, 5, -7, 6, -3], target = 0
 * Output: [1, 5]
 * Explanation: nums[1] + nums[5] = 3 + (-3) = 0
 * 
 * Brute force:
 * pick one element and add it with rest of the elment one by one
 * if the sum == target then return the indexs of the selected two elementss
 * 
 * 
 * Optimal:
 * Create one map to store the elements we checked with their index {element:
 * index}
 * 
 * iterate the array
 * find the complement(difference between the target and current element)
 * if complement exist in map, return the index of current element and
 * complement
 * if not then store the current element in map {currElement: index}
 * 
 */

public class solution {
    // Brute force
    int[] twoSum1(int[] nums, int target) {
        int[] res = { -1, -1 };

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }

        return res;
    }

    // Optimal
    int[] twoSum2(int[] nums, int target) {

        // Map to store (element, index) pairs
        Map<Integer, Integer> mpp = new HashMap<>();

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // Current number in the array
            int num = nums[i];

            // Number needed to reach the target
            int moreNeeded = target - num;

            // Check if the complement exists in map
            if (mpp.containsKey(moreNeeded)) {
                /*
                 * Return the indices of the two
                 * numbers that sum up to target
                 */
                return new int[] { mpp.get(moreNeeded), i };
            }

            // Store current number and its index in map
            mpp.put(num, i);
        }

        // If no such pair found, return {-1, -1}
        return new int[] { -1, -1 };
    }
}