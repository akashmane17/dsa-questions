/*
Given an integer array nums of size n, return the majority element of the array.
The majority element of an array is an element that appears more than n/2 times in the array. The array is guaranteed to have a majority element.

Examples:

Input: nums = [7, 0, 0, 1, 7, 7, 2, 7, 7]
Output: 7
Explanation: The number 7 appears 5 times in the 9 sized array

Input: nums = [1, 1, 1, 2, 1, 2]
Output: 1
Explanation: The number 1 appears 4 times in the 6 sized array
*/

class Solution {
  majorityElement1(nums) {
    let element = nums[0];

    // Iterate through the array
    for (let i = 0; i < nums.length; i++) {
      let count = 0;

      for (let j = 0; j < nums.length; j++) {
        if (nums[i] === nums[j]) {
          count++;
        }
      }

      if (count > nums.length / 2) {
        element = nums[i];
        break;
      }
    }

    return element;
  }

  majorityElement2(nums) {
    // Initialize count to 0 and set the first element of the array as the potential majority element
    let count = 0;
    let element = nums[0];

    // Iterate through the array
    for (let i = 0; i < nums.length; i++) {
      // If count is 0, choose the current element as the new candidate for majority element
      if (count === 0) {
        element = nums[i];
        count++; // Increase count since we're considering this element
      }
      // If the current element is the same as the candidate, increase the count
      else if (element === nums[i]) {
        count++;
      }
      // If the current element is different, decrease the count
      else {
        count--;
      }
    }

    // Return the element that is the majority element
    return element;
  }
}
