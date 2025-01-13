package Arrays.D_Hard.findMissingAndRepeatingNum;

/**
 * Given an integer array nums of size n containing values from [1, n] and each
 * value appears exactly once in the array, except for A, which appears twice
 * and B which is missing.
 * Return the values A and B, as an array of size 2, where A appears in the 0-th
 * index and B in the 1st index.
 * 
 * Examples:
 * 
 * Input: nums = [3, 5, 4, 1, 1]
 * Output: [1, 2]
 * Explanation: 1 appears two times in the array and 2 is missing from nums
 * 
 * Input: nums = [1, 2, 3, 6, 7, 5, 7]
 * Output: [7, 4]
 * Explanation: 7 appears two times in the array and 4 is missing from nums.
 */

import java.util.*;

public class Solution {

    // Brute-force approach
    public int[] findMissingRepeatingNumbers1(int[] nums) {
        int[] res = new int[2]; // res[0] = repeating, res[1] = missing
        int n = nums.length;

        // Iterate over numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            int count = 0;

            // Count occurrences of number 'i'
            for (int num : nums) {
                if (num == i) {
                    count++;
                }
            }

            // Check if the number is repeating or missing
            if (count == 2) {
                res[0] = i; // Repeating number
            } else if (count == 0) {
                res[1] = i; // Missing number
            }
        }

        return res;
    }

    // Better approach using a hash array
    public int[] findMissingRepeatingNumbers2(int[] nums) {
        int n = nums.length;
        int[] hash = new int[n + 1];
        int repeating = -1, missing = -1;

        // Update the hash array with counts of each number
        for (int num : nums) {
            hash[num]++;
        }

        // Find the repeating and missing numbers
        for (int i = 1; i <= n; i++) {
            if (hash[i] == 2) {
                repeating = i; // Repeating number
            } else if (hash[i] == 0) {
                missing = i; // Missing number
            }

            // Break out of the loop if both are found
            if (repeating != -1 && missing != -1) {
                break;
            }
        }

        return new int[] { repeating, missing };
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = { 4, 3, 6, 2, 1, 1 };

        // Test Method 1
        System.out.println("Brute-force Result: " + Arrays.toString(solution.findMissingRepeatingNumbers1(nums)));

        // Test Method 2
        System.out.println("Better Approach Result: " + Arrays.toString(solution.findMissingRepeatingNumbers2(nums)));
    }
}
