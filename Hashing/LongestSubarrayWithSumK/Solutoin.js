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
  subarraySum(nums, k) {
    let count = 0;

    for (let i = 0; i < nums.length; i++) {
      let sum = 0;
      for (let j = i; j < nums.length; j++) {
        sum += nums[j];
        if (sum === k) {
          count = count + 1;
        }
      }
    }

    return count;
  }
}

/*
Optimal : Using prefix Sum method
calculate sum till index i
calculate (rem) value to remove which is (sum - K)
check if the map contains the value you calculate (rem) and update count
update the sum in the map
*/
class Solution {
  subarraySum(nums, k) {
    let count = 0;

    let map = new Map();
    let sum = 0;

    // Setting 0 in the map.
    map.set(0, 1);

    for (let i = 0; i < nums.length; i++) {
      // Add current element to prefix sum:
      sum += nums[i];

      /* Calculate the value to remove
            (sum - k)*/
      let rem = sum - k;

      /* Add the number of subarrays 
            with the sum to be removed*/
      count += map.get(rem) || 0;

      /* Update the count of current 
            prefix sum in the map*/
      map.set(sum, (map.get(sum) || 0) + 1);
    }

    return count;
  }
}
