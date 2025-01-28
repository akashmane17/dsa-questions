/*
First and last occurrence
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value. If the target is not found in the array, return [-1, -1].

Examples:
Input: nums = [5, 7, 7, 8, 8, 10], target = 8
Output: [3, 4]
Explanation:The target is 8, and it appears in the array at indices 3 and 4, so the output is [3,4]

Input: nums = [5, 7, 7, 8, 8, 10], target = 6
Output: [-1, -1]
Expalantion: The target is 6, which is not present in the array. Therefore, the output is [-1, -1].
*/

class Solution {
  // Find the first occurance
  firstOcc(nums, target) {
    let low = 0;
    let high = nums.length - 1;

    let first = -1;

    while (low <= high) {
      let mid = Math.floor((low + high) / 2);

      // if target is found, update the value of first and keep searching on left side for First occurance
      if (nums[mid] === target) {
        first = mid;
        high = mid - 1; // keep searching on left side
      } else if (nums[mid] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return first;
  }

  // Find the Last occurance
  lastOcc(nums, target) {
    let low = 0;
    let high = nums.length - 1;

    let last = -1;

    while (low <= high) {
      let mid = Math.floor((low + high) / 2);

      // if target is found, update the value of last and keep searching on right side for last occurance
      if (nums[mid] === target) {
        last = mid;
        low = mid + 1; // keep searching on right side
      } else if (nums[mid] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return last;
  }

  searchRange(nums, target) {
    let first = this.firstOcc(nums, target);
    let last = this.lastOcc(nums, target);

    return [first, last];
  }
}
