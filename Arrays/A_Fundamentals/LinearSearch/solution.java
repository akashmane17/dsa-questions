package Arrays.A_Fundamentals.LinearSearch;

/**
 * Linear Search
 * 
 * Given an array of integers nums and an integer target,
 * find the smallest index (0 based indexing) where the target appears in the
 * array.
 * If the target is not found in the array, return -1.
 * 
 * Example 1
 * Input: nums = [2, 3, 4, 5, 3], target = 3
 * Output: 1
 * Explanation: The first occurence of 3 in nums is at index 1
 * 
 * Example 2
 * Input: nums = [2, -4, 4, 0, 10], target = 6
 * Output: -1
 * Explanation: The value 6 does not occur in the array, hence output is -1
 * 
 * Approach: iterate over every element of the array until the target element is
 * found, if the target element if found return its index
 * return -1 if the target is not present in array
 * 
 * Time complexity : O(n)
 * Space complexity : O(1)
 */

class Solution {
  public int linearSearch(int nums[], int target) {
    int n = nums.length;

    if (n == 0)
      return -1;

    for (int i = 0; i < n; i++) {
      if (nums[i] == target) {
        return i;
      }
    }

    return -1;
  }
}