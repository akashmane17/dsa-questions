package BinarySearch.B_LogicBuilding.FloorAndCeil;

/*
Floor and Ceil in Sorted Array
Given a sorted array nums and an integer x. Find the floor and ceil of x in nums. The floor of x is the largest element in the array which is smaller than or equal to x. The ceiling of x is the smallest element in the array greater than or equal to x. If no floor or ceil exists, output -1.

Examples:
Input : nums =[3, 4, 4, 7, 8, 10], x= 5
Output: 4 7
Explanation: The floor of 5 in the array is 4, and the ceiling of 5 in the array is 7.

Input : nums =[3, 4, 4, 7, 8, 10], x= 8
Output: 8 8
Explanation: The floor of 8 in the array is 8, and the ceiling of 8 in the array is also 8.
*/

class Solution {
    public int[] getFloorAndCeil(int[] nums, int x) {
        int n = nums.length;
        int low = 0, high = n - 1;
        int floor = -1; // Initialize floor as -1
        int ceil = -1; // Initialize ceil as -1

        while (low <= high) {
            int mid = low + (high - low) / 2; // Avoid overflow

            // If x is found
            if (nums[mid] == x) {
                floor = nums[mid];
                ceil = nums[mid];
                return new int[] { floor, ceil };
            }
            // Update ceil if x is smaller than nums[mid]
            else if (nums[mid] > x) {
                ceil = nums[mid];
                high = mid - 1;
            }
            // Update floor if x is greater than nums[mid]
            else {
                floor = nums[mid];
                low = mid + 1;
            }
        }

        return new int[] { floor, ceil };
    }
}
