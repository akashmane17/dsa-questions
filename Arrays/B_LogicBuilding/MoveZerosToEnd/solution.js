/**
Move Zeros to End

Given an integer array nums, move all the 0's to the end of the array. The relative order of the other elements must remain the same. This must be done in place, without making a copy of the array.

Example 1
Input: nums = [0, 1, 4, 0, 5, 2]
Output: [1, 4, 5, 2, 0, 0]
Explanation: Both the zeroes are moved to the end and the order of the other elements stay the same

Example 2
Input: nums = [0, 0, 0, 1, 3, -2]
Output: [1, 3, -2, 0, 0, 0]
Explanation: All 3 zeroes are moved to the end and the order of the other elements stay the same

Brute force approach:
we can create temp array
fill it with zeros
then store all non zero elements sequentially
replace old array with the temp array

Optimal
Use of two pointer


*/

class Solution {
  moveZeroes(nums) {
    let lastNonZeroFoundAt = 0;

    for (let i = 0; i < nums.length; i++) {
      if (nums[i] !== 0) {
        // let temp = nums[i];
        // nums[i] = nums[lastNonZeroFoundAt];
        // nums[lastNonZeroFoundAt] = temp;
        // lastNonZeroFoundAt++;

        // above swapping can also be written as below
        [nums[lastNonZeroFoundAt++], nums[i]] = [
          nums[i],
          nums[lastNonZeroFoundAt],
        ];
      }
    }
  }
}
