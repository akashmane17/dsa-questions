package BinarySearch.searchXintheSortedArray;

/*
Search X in sorted array
Given a sorted array of integers nums with 0-based indexing, find the index of a specified target integer. If the target is found in the array, return its index. If the target is not found, return -1.

Examples:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: The target integer 9 exists in nums and its index is 4

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: The target integer 2 does not exist in nums so return -1F

Approach: Binary search
pick a mid element if its equal to target then return index
if it is greater than target, search on the left side
if it is smaller than target, search on the right side

init low = 0; high = nums.length - 1;
mid = (low + high)/2;

case 1: nums[mid] == target, return mid
case 2: nums[mid] > target, low = mid - 1;
case 3: nums[mid] < target, high = high + 1;
*/

class Solution {
    // Function to find the given target in a sorted array
    public int search(int[] nums, int target) {
        int n = nums.length; // Size of array

        // Pointers to define the search space
        int low = 0, high = n - 1;

        // Until the search space is not empty
        while (low <= high) {
            // Find the middle element
            int mid = (low + high) / 2;

            // If it matches the target
            if (nums[mid] == target)
                return mid;

            // If the target is greater than middle element
            else if (target > nums[mid])
                low = mid + 1;

            // Otherwise
            else
                high = mid - 1;
        }

        // If the target is not found
        return -1;
    }
}