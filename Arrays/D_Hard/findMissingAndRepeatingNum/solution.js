/**
Given an integer array nums of size n containing values from [1, n] and each value appears exactly once in the array, except for A, which appears twice and B which is missing.
Return the values A and B, as an array of size 2, where A appears in the 0-th index and B in the 1st index.

Examples:

Input: nums = [3, 5, 4, 1, 1]
Output: [1, 2]
Explanation: 1 appears two times in the array and 2 is missing from nums

Input: nums = [1, 2, 3, 6, 7, 5, 7]
Output: [7, 4]
Explanation: 7 appears two times in the array and 4 is missing from nums.
 */

class Solution {
  // brute force
  findMissingRepeatingNumbers1(nums) {
    let res = [0, 0];

    for (let i = 1; i <= nums.length; i++) {
      let count = 0;
      for (let num of nums) {
        if (num === i) count++;
      }

      if (count === 2) res[0] = i;
      if (count === 0) res[1] = i;
    }

    return res;
  }

  // better

  findMissingRepeatingNumbers2(nums) {
    // Size of the array
    let n = nums.length;

    // Hash array to count occurrences
    let hash = Array(n + 1).fill(0);

    // Update the hash array:
    for (let num of nums) {
      hash[num]++;
    }

    let repeating = -1,
      missing = -1;

    // Find the repeating and missing number:
    for (let i = 1; i <= n; i++) {
      if (hash[i] === 2) {
        repeating = i;
      } else if (hash[i] === 0) {
        missing = i;
      }

      /* If both repeating and missing 
            are found, break out of loop*/
      if (repeating !== -1 && missing !== -1) {
        break;
      }
    }

    // Return [repeating, missing]
    return [repeating, missing];
  }
}
