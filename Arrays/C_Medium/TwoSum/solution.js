/**
Given an array of integers nums and an integer target. Return the indices(0 - indexed) of two elements in nums such that they add up to target.
Each input will have exactly one solution, and the same element cannot be used twice. Return the answer in non-decreasing order.

Example 1
Input: nums = [1, 6, 2, 10, 3], target = 7
Output: [0, 1]
Explanation: nums[0] + nums[1] = 1 + 6 = 7

Example 2
Input: nums = [1, 3, 5, -7, 6, -3], target = 0
Output: [1, 5]
Explanation: nums[1] + nums[5] = 3 + (-3) = 0 

Brute force: 
    pick one element and add it with rest of the elment one by one
    if the sum == target then return the indexs of the selected two elementss


Optimal:
Create one map to store the elements we checked with their index {element: index}

iterate the array
find the complement(difference between the target and current element)
if complement exist in map, return the index of current element and complement
if not then store the current element in map {currElement: index}

 */

class Solution {
  // Brute force
  twoSum1(nums, target) {
    let res = [-1, -1];

    for (let i = 0; i < nums.length - 1; i++) {
      for (let j = 0; j < nums.length; j++) {
        if (nums[i] + nums[j] === target) {
          res[0] = i;
          res[1] = j;
          return res;
        }
      }
    }

    return res;
  }

  // Optimal
  twoSum(nums, target) {
    let res = [-1, -1];

    // Map to store (element, index) pairs
    let map = new Map();

    for (let i = 0; i < nums.length; i++) {
      // Number needed to reach the target
      let complement = target - nums[i];

      // Number needed to reach the target
      if (map.has(complement)) {
        /* Return the indices of the 
                    two numbers that sum up to target*/
        let index = map.get(complement);
        res[0] = i;
        res[1] = index;
        return res;
      }

      // Store current number and its index in map
      map.set(nums[i], i);
    }

    return res;
  }
}
