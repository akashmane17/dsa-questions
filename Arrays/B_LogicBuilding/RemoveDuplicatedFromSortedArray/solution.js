/**
Remove duplicates from sorted array

Given an integer array nums sorted in non-decreasing order, 
remove all duplicates in-place so that each unique element appears only once. 
Return the number of unique elements in the array.

If the number of unique elements be k, then,
    Change the array nums such that the first k elements of nums contain the unique values in the order that they were present originally.
    The remaining elements, as well as the size of the array does not matter in terms of correctness.

An array sorted in non-decreasing order is an array where every element to the right of an element in either equal to or greater in value than that element.

Example 1
Input: nums = [0, 0, 3, 3, 5, 6]
Output: [0, 3, 5, 6, _, _]
Explanation: There are 4 distinct elements in nums and the elements marked as _ can have any value.

Example 2
Input: nums = [-2, 2, 4, 4, 4, 4, 5, 5]
Output: [-2, 2, 4, 5, _, _, _, _]
Explanation: There are 4 distinct elements in nums and the elements marked as _ can have any value.
*/

class Solution {
  removeDuplicates(nums) {
    if (nums.length === 0) return 0;

    // Index of the last unique element encountered
    let i = 0;

    for (let j = 1; j < nums.length; j++) {
      // If the current element is different from the last unique element
      if (nums[i] !== nums[j]) {
        // Increment the index of the last unique element
        i++;
        // Replace the next unique element with the current element
        nums[i] = nums[j];
      }
    }

    // Return the length of the unique subarray
    return i + 1;
  }
}
