package Arrays.B_LogicBuilding.MoveZerosToEnd;

/**
 * Move Zeros to End
 * 
 * Given an integer array nums, move all the 0's to the end of the array. The
 * relative order of the other elements must remain the same. This must be done
 * in place, without making a copy of the array.
 * 
 * Example 1
 * Input: nums = [0, 1, 4, 0, 5, 2]
 * Output: [1, 4, 5, 2, 0, 0]
 * Explanation: Both the zeroes are moved to the end and the order of the other
 * elements stay the same
 * 
 * Example 2
 * Input: nums = [0, 0, 0, 1, 3, -2]
 * Output: [1, 3, -2, 0, 0, 0]
 * Explanation: All 3 zeroes are moved to the end and the order of the other
 * elements stay the same
 * 
 * Brute force approach:
 * we can create temp array
 * fill it with zeros
 * then store all non zero elements sequentially
 * replace old array with the temp array
 * 
 * Optimal
 * Use of two pointer
 * 
 * 
 */

class Solution {
    public void moveZeroes(int[] nums) {
        int lastNonZeroFoundAt = 0;

        // Iterate through the array
        for (int cur = 0; cur < nums.length; cur++) {
            // If the current element is not zero
            if (nums[cur] != 0) {
                // Swap the current element with the element at lastNonZeroFoundAt
                int temp = nums[lastNonZeroFoundAt];
                nums[lastNonZeroFoundAt] = nums[cur];
                nums[cur] = temp;

                // Increment lastNonZeroFoundAt to point to the next position for non-zero
                // elements
                lastNonZeroFoundAt++;
            }
        }
    }
}