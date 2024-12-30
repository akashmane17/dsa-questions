/**
Left Rotate Array by One

Given an integer array nums, rotate the array to the left by one.

Example 1
Input: nums = [1, 2, 3, 4, 5]
Output: [2, 3, 4, 5, 1]
Explanation: Initially, nums = [1, 2, 3, 4, 5]
Rotating once to left -> nums = [2, 3, 4, 5, 1]

Example 2
Input: nums = [-1, 0, 3, 6]
Output: [0, 3, 6, -1]
Explanation: Initially, nums = [-1, 0, 3, 6]
Rotating once to left -> nums = [0, 3, 6, -1]

Approach:
Initalization: store the first element of the array in temp variable

iterate over an array and store the nums[i+1] to at nums[i]s
 0   1  2  3
[-1, 0, 3, 6]
[0, 0, 3, 6] store 0 at index 0
[0, 3, 3, 6] store 3 at index 1
[0, 3, 6, 6] store 6 at index 2

At alas store the value of temp in the last index 4
[0, 3, 6, -1]

Time complexity : O(n)
Space complexity : O(1)

*/

class Solution {
  rotateArrayByOne(nums) {
    let firstElement = nums[0];
    let n = nums.length;

    for (let i = 0; i < n; i++) {
      // store next element to the current position
      nums[i] = nums[i + 1];
    }

    nums[n - 1] = firstElement;
  }
}
