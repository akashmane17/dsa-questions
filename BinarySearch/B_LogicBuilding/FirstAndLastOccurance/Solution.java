package BinarySearch.B_LogicBuilding.FirstAndLastOccurance;

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
    // Find the first occurrence
    public int firstOcc(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int first = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Avoid overflow

            // If target is found, update first and search on the left side
            if (nums[mid] == target) {
                first = mid;
                high = mid - 1; // Continue searching in the left half
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return first;
    }

    // Find the last occurrence
    public int lastOcc(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int last = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Avoid overflow

            // If target is found, update last and search on the right side
            if (nums[mid] == target) {
                last = mid;
                low = mid + 1; // Continue searching in the right half
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return last;
    }

    public int[] searchRange(int[] nums, int target) {
        int first = firstOcc(nums, target);
        int last = lastOcc(nums, target);
        return new int[] { first, last };
    }
}
