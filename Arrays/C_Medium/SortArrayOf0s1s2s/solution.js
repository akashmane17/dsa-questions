/**
Sort an array of 0's 1's and 2's

Given an array nums consisting of only 0, 1, or 2. Sort the array in non-decreasing order. The sorting must be done in-place, without making a copy of the original array.

Example 1
Input: nums = [1, 0, 2, 1, 0]
Output: [0, 0, 1, 1, 2]
Explanation: The nums array in sorted order has 2 zeroes, 2 ones and 1 two

Example 2
Input: nums = [0, 0, 1, 1, 1]
Output: [0, 0, 1, 1, 1]
Explanation: The nums array in sorted order has 2 zeroes, 3 ones and zero twos

Appraoch:
Initialization: create 3 variables, count1, count0

first loop to count all the occurance of 0,1 to respective count variables

then we'll loop from 0 to count0-1 to store all the zeros
then count0 to count1-1 to store all the one
and rest will be count1 to length of the array those will be 2

 */

class Solution {
  sortZeroOneTwo(nums) {
    let cnt0 = 0,
      cnt1 = 0;

    // Counting the number of 0s, 1s, and 2s in the array
    for (let i = 0; i < nums.length; i++) {
      if (nums[i] == 0) cnt0++;
      else if (nums[i] == 1) cnt1++;
    }

    /* Placing the elements in the
           original array based on counts */
    // placing 0's
    for (let i = 0; i < cnt0; i++) nums[i] = 0;

    // placing 1's
    for (let i = cnt0; i < cnt0 + cnt1; i++) nums[i] = 1;

    // placing 2's
    for (let i = cnt0 + cnt1; i < nums.length; i++) nums[i] = 2;
  }
}
