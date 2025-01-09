/**
Given an integer array nums, find the subarray with the largest sum and return the sum of the elements present in that subarray.
A subarray is a contiguous non-empty sequence of elements within an array.

Examples:

Input: nums = [2, 3, 5, -2, 7, -4]
Output: 15
Explanation: The subarray from index 0 to index 4 has the largest sum = 15

Input: nums = [-2, -3, -7, -2, -10, -4]
Output: -2
Explanation: The element on index 0 or index 3 make up the largest sum when taken as a subarray
 */
class Solution {
  maxSubArray(nums) {
    let maxi = Number.MIN_SAFE_INTEGER;
    let sum = 0;

    // Iterate over each starting index of subarrays
    for (let i = 0; i < nums.length; i++) {
      sum += nums[i];

      if (sum > maxi) {
        maxi = sum;
      }

      // Reset sum to 0 if it becomes negative
      if (sum < 0) {
        sum = 0;
      }
    }

    // Return the maximum subarray sum found
    return maxi;
  }
}
