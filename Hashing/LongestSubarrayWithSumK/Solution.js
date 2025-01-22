/*
 * Longest subarray with sum K
 *
 * Given an array nums of size n and an integer k, find the length of the
 * longest sub-array that sums up to k. If no such sub-array exists, return 0.
 *
 * Examples:
 *
 * Input: nums = [10, 5, 2, 7, 1, 9], k=15
 * Output: 4
 * Explanation: The longest sub-array with a sum equal to 15 is [5, 2, 7, 1],
 * which has a length of 4. This sub-array starts at index 1 and ends at index
 * 4, and the sum of its elements (5 + 2 + 7 + 1) equals 15. Therefore, the
 * length of this sub-array is 4.
 *
 * Input: nums = [-3, 2, 1], k=6
 * Output: 0
 * Explanation: There is no sub-array in the array that sums to 6. Therefore,
 * the output is 0.
 */

/*
Brute Force: calculate sum of every possible subarray and if sum matches k increment the count
*/

class Solution1 {
  longestSubarray(nums, k) {
    let res = 0;
    let n = nums.length;

    for (let i = 0; i < n; i++) {
      let sum = 0;
      for (let j = i; j < n; j++) {
        sum += nums[j];

        if (sum === k) {
          let count = j - i + 1;
          res = Math.max(res, count);
        }
      }
    }

    return res;
  }
}

/*
Optimal : Using prefix Sum method
*/
class Solution {
  longestSubarray(nums, k) {
    const n = nums.length;

    const preSumMap = new Map();
    let sum = 0;
    let maxLen = 0;

    for (let i = 0; i < n; i++) {
      // calculate the prefix sum till index i
      sum += nums[i];

      // if the sum equals k, update maxLen
      if (sum === k) {
        maxLen = Math.max(maxLen, i + 1);
      }

      // calculate the sum of remaining part i.e., sum - k
      const rem = sum - k;

      // calculate the length and update maxLen
      if (preSumMap.has(rem)) {
        const len = i - preSumMap.get(rem);
        maxLen = Math.max(maxLen, len);
      }

      // update the map if sum is not already present
      if (!preSumMap.has(sum)) {
        preSumMap.set(sum, i);
      }
    }

    return maxLen;
  }
}
