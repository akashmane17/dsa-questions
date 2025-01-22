/*
Count subarrays with given xor K
Given an array of integers nums and an integer k, return the total number of subarrays whose XOR equals to k.

Examples:
Input : nums = [4, 2, 2, 6, 4], k = 6
Output : 4
Explanation : The subarrays having XOR of their elements as 6 are [4, 2],  [4, 2, 2, 6, 4], [2, 2, 6], and [6]

Input :nums = [5, 6, 7, 8, 9], k = 5
Output : 2
Explanation : The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9]F
*/

// Brute Force
class Solution1 {
  subarraysWithXorK(nums, k) {
    let n = nums.length;

    let count = 0;

    for (let i = 0; i < n; i++) {
      let xorr = 0;

      for (let j = i; j < n; j++) {
        xorr ^= nums[j];

        if (xorr === k) {
          count++;
        }
      }
    }

    return count;
  }
}

// Optimal
class Solution {
  subarraysWithXorK(nums, k) {
    const n = nums.length;
    let xr = 0;
    const mpp = new Map();

    // setting the value of 0.
    mpp.set(xr, 1);
    let cnt = 0;

    for (let i = 0; i < n; i++) {
      // prefix XOR till index i:
      xr = xr ^ nums[i];

      // By formula: x = xr ^ k:
      const x = xr ^ k;

      // add the occurrence of xr ^ k to the count:
      cnt += mpp.get(x) || 0;

      // Insert the prefix xor till index i into the map:
      mpp.set(xr, (mpp.get(xr) || 0) + 1);
    }
    return cnt;
  }
}
