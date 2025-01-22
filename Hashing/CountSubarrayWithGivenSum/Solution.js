/*
Count subarrays with given sum
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

Examples:
Input: nums = [1, 1, 1], k = 2
Output: 2
Explanation: In the given array [1, 1, 1], there are two subarrays that sum up to 2: [1, 1] and [1, 1]. Hence, the output is 2.

Input: nums = [1, 2, 3], k = 3
Output: 2
Explanation: In the given array [1, 2, 3], there are two subarrays that sum up to 3: [1, 2] and [3]. Hence, the output is 2.F
*/

// Brute borce: check sum of all the possible sub arrays
class Solution {
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

// Optimal
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
