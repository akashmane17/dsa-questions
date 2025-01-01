/**
Leaders in an Array

Given an integer array nums, return a list of all the leaders in the array.

A leader in an array is an element whose value is strictly greater than all elements to its right in the given array. 
The rightmost element is always a leader. The elements in the leader array must appear in the order they appear in the nums array.

Example 1
Input: nums = [1, 2, 5, 3, 1, 2]
Output: [5, 3, 2]
Explanation: 2 is the rightmost element, 3 is the largest element in the index range [3, 5], 5 is the largest element in the index range [2, 5]

Example 2
Input: nums = [-3, 4, 5, 1, -4, -5]
Output: [5, 1, -4, -5]
Explanation: -5 is the rightmost element, -4 is the largest element in the index range [4, 5], 1 is the largest element in the index range [3, 5] and 5 is the largest element in the range [2, 5]

BruteForce: use two loops
outer loop will pick element from array
inner loop compares that element with all the elements to its right (selected element > all elements to right)
then that element is leader
Last element is always a leader


Optimal: 
The code iterates through the input array nums from right to left.
It keeps track of the previousLeader, initially set to the last element of the array.
For each element, it checks if the currentElement is greater than the previousLeader.
If it is, the currentElement is a leader, and it's added to the res array. The previousLeader is then updated to the currentElement.

Reverse the array and return it
 */

class Solution {
  // Brute force
  leaders1(nums) {
    let res = [];

    for (let i = 0; i < nums.length; i++) {
      let isLeader = true;
      for (let j = i + 1; j < nums.length; j++) {
        if (nums[i] <= nums[j]) {
          isLeader = false;
          break;
        }
      }

      if (isLeader) res.push(nums[i]);
    }

    return res;
  }

  // Optimal
  leaders2(nums) {
    let res = [];
    let n = nums.length;

    let previousLeader = nums[n - 1];
    res.push(previousLeader);

    for (let i = n - 2; i >= 0; i--) {
      let currentElement = nums[i];

      if (currentElement > previousLeader) {
        res.push(currentElement);
        previousLeader = currentElement;
      }
    }

    // Reverse the array
    let left = 0;
    let right = n - 1;
    while (left < right) {
      [res[left], res[right]] = [res[right], res[left]];
      left++;
      right--;
    }

    return res;
  }
}