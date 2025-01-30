/*
Search in rotated sorted array-II

Given an integer array nums, sorted in ascending order (may contain duplicate values) and a target value k. Now the array is rotated at some pivot point unknown to you. Return True if k is present and otherwise, return False.

Examples:

Input : nums = [7, 8, 1, 2, 3, 3, 3, 4, 5, 6], k = 3
Output: True
Explanation: The element 3 is present in the array. So, the answer is True.

Input : nums = [7, 8, 1, 2, 3, 3, 3, 4, 5, 6], k = 10
Output: False
Explanation:The element 10 is not present in the array. So, the answer is False.

Approach: Use binary search
using low, mid and high pointer, you'll divide array in to parts left and right

check if low, mid and high are equal if they are do low++; and high-- to avoid duplicate

if nums[low] <= nums[mid] then left part is sorted
    if left is sorted check if the target exists in the range of low to mid if it does set high = mid - 1
    else set low = mid + 1, to search further

Similarly if left part is not sorted right might be
so in else block after (nums[low] <= nums[mid])
check if the target exists in the range of mid to high if it does set low = mid + 1
else set high = mid - 1

*/

class Solution {
  /* Function to search for the target element 
     in a rotated sorted array with duplicates */
  searchInARotatedSortedArrayII(arr, target) {
    let n = arr.length;
    let low = 0,
      high = n - 1;

    // Applying binary search algorithm
    while (low <= high) {
      let mid = Math.floor((low + high) / 2);

      // Check if mid points to the target
      if (arr[mid] === target) return true;

      /* Handle duplicates: if arr[low], arr[mid], 
             and arr[high] are equal */
      if (arr[low] === arr[mid] && arr[mid] === arr[high]) {
        low = low + 1;
        high = high - 1;
        continue;
      }

      // Check if the left part is sorted
      if (arr[low] <= arr[mid]) {
        /* Eliminate the right part if target
                 exists in the left sorted part */
        if (arr[low] <= target && target <= arr[mid]) {
          high = mid - 1;
        }
        // Otherwise eliminate the left part
        else {
          low = mid + 1;
        }
      } else {
        /* If the right part is sorted and
                 target exists in the right sorted
                 part, eliminate the left part */
        if (arr[mid] <= target && target <= arr[high]) {
          low = mid + 1;
        }
        // Otherwise eliminate the right part
        else {
          high = mid - 1;
        }
      }
    }
    // If target is not found
    return false;
  }
}
