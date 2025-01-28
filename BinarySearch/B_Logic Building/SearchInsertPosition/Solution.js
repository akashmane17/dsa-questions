/*
Search insert position
Given a sorted array of nums consisting of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

Examples:
Input: nums = [1, 3, 5, 6], target = 5
Output: 2
Explanation: The target value 5 is found at index 2 in the sorted array. Hence, the function returns 2.

Input: nums = [1, 3, 5, 6], target = 2
Output: 1
Explanation: The target value 2 is not found in the array. However, it should be inserted at index 1 to maintain the sorted order of the array.F
*/

// similar to finding the upper bound or ceil
class Solution {
  searchInsert(nums, target) {
    let n = nums.length;
    let low = 0;
    let high = n - 1;

    let ans = n;

    while (low <= high) {
      let mid = Math.floor((low + high) / 2);

      // check if the target is greater than or equal to the mid element
      // might be possible answer if it is
      if (nums[mid] >= target) {
        ans = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return ans;
  }
}
