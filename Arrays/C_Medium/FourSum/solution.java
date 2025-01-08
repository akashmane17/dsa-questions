package Arrays.C_Medium.FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an integer array nums and an integer target. Return all quadruplets
 * [nums[a], nums[b], nums[c], nums[d]] such that:
 * · a, b, c, d are all distinct valid indices of nums.
 * · nums[a] + nums[b] + nums[c] + nums[d] == target.
 * 
 * Notice that the solution set must not contain duplicate quadruplets. One
 * element can be a part of multiple quadruplets. The output and the quadruplets
 * can be returned in any order.
 * 
 * Examples:
 * Input: nums = [1, -2, 3, 5, 7, 9], target = 7
 * Output: [[-2, 1, 3, 5]]
 * Explanation: nums[1] + nums[0] + nums[2] + nums[3] = 7
 * 
 * Input: nums = [7, -7, 1, 2, 14, 3], target = 9
 * Output: []
 * Explanation: No quadruplets are present which add upto 9
 */

public class solution {
    // Brute force approach
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // size of the array
        int n = nums.length;

        // Set to store unique quadruplets
        Set<List<Integer>> set = new HashSet<>();

        // Checking all possible quadruplets
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        // Calculate the sum of the current quadruplet
                        long sum = nums[i] + nums[j] + nums[k] + nums[l];

                        // Check if the sum matches the target
                        if (sum == target) {
                            List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            // Sort the quadruplet to ensure uniqueness
                            Collections.sort(temp);
                            set.add(temp);
                        }
                    }
                }
            }
        }

        // Convert set to list (unique quadruplets)
        return new ArrayList<>(set);
    }

    // Optimal Way
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        // Get the size of the array
        int n = nums.length;

        // Sort the array to make it easier to avoid duplicates and use two-pointer
        // technique
        Arrays.sort(nums);

        // Initialize the result list to store unique quadruplets
        List<List<Integer>> result = new ArrayList<>();

        // First loop to fix the first number
        for (int i = 0; i < n; i++) {
            // Skip duplicate values for the first number
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            // Second loop to fix the second number
            for (int j = i + 1; j < n; j++) {
                // Skip duplicate values for the second number
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                // Use two pointers for the remaining two numbers
                int left = j + 1;
                int right = n - 1;

                // Find the two numbers that sum up with nums[i] and nums[j] to match the target
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    // If the sum matches the target, add the quadruplet to the result list
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // Move the left pointer to skip duplicate values
                        while (left < right && nums[left] == nums[left + 1])
                            left++;
                        // Move the right pointer to skip duplicate values
                        while (left < right && nums[right] == nums[right - 1])
                            right--;

                        // Move both pointers to continue searching
                        left++;
                        right--;
                    }
                    // If the sum is less than the target, move the left pointer to increase the sum
                    else if (sum < target) {
                        left++;
                    }
                    // If the sum is greater than the target, move the right pointer to decrease the
                    // sum
                    else {
                        right--;
                    }
                }
            }
        }

        // Return the list of unique quadruplets
        return result;
    }
}
