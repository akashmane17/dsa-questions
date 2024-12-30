package Arrays.A_Fundamentals.MaximumConsecutiveOnes;

/**
 * Maximum Consecutive Ones
 * 
 * Given a binary array nums, return the maximum number of consecutive 1s in the
 * array.
 * A binary array is an array that contains only 0s and 1s.
 * 
 * Example 1
 * Input: nums = [1, 1, 0, 0, 1, 1, 1, 0]
 * Output: 3
 * Explanation: The maximum consecutive 1s are present from index 4 to index 6,
 * amounting to 3 1s
 * 
 * Example 2
 * Input: nums = [0, 0, 0, 0, 0, 0, 0, 0]
 * Output: 0
 * Explanation: No 1s are present in nums, thus we return 0
 * 
 * Approach:
 * Initialization:
 * two variables count, and maxConsecutive
 * count for count the consecutive while iterating
 * maxConsecutive to store the maximum one
 * 
 * Iterate over the array
 * for every Iteration:
 * If element is 0, set count = 0;
 * If element is 1, increment count by 1, and if count is greater than
 * maxConsecutive then store it in maxConsecutive
 * 
 * Return maxConsecutive at the end
 * 
 * Time complexity : O(n)
 * Space complexity : O(1)
 */

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0;
        int max = 0;

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {

            // If the current element is 1, increment the count
            if (nums[i] == 1) {
                cnt++;
                // Update max if current count is greater than max
                max = Math.max(max, cnt);

            } else {
                // If the current element is 0, reset the count
                cnt = 0;
            }
        }
        // Return the maximum count of consecutive 1s
        return max;
    }
}
