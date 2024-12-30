/**
 * Largest Element in the array
 *
 * Given an array of integers nums, return the value of the largest element in
 * the array.
 *
 * Example 1
 * Input: nums = [3, 3, 6, 1]
 * Output: 6
 * Explanation: The largest element in array is 6
 *
 * Example 2
 * Input: nums = [3, 3, 0, 99, -40]
 * Output: 99
 * Explanation: The largest element in array is 99
 *
 * Approach:
 * Brute: sort the array, and return the last element
 * Time complexity : O(n * logN)
 * Space complexity : O(1)
 *
 * Optimal:
 * Set the initial max value to the first element of the array.
 * Traverse the array.
 * In each iteration:
 * Compare the current max with the current element.
 * If the current element is greater than max, update max with the current
 * element.
 * After iterating through the entire array, return the max value.
 *
 * Time complexity : O(n)
 * Space complexity : O(1)
 */

class Solution {
  largestElement(nums) {
    let n = nums.length;
    if (n === 1) return nums[0];

    let max = nums[0];

    for (let i = 0; i < n; i++) {
      if (nums[i] > max) {
        max = nums[i];
      }
    }

    return max;
  }
}
