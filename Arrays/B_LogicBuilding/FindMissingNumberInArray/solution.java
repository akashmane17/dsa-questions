package Arrays.B_LogicBuilding.FindMissingNumberInArray;

/**
 * Given an integer array of size n containing distinct values in the range from
 * 0 to n (inclusive), return the only number missing from the array within this
 * range.
 * 
 * Example 1
 * Input: nums = [0, 2, 3, 1, 4]
 * Output: 5
 * Explanation: nums contains 0, 1, 2, 3, 4 thus leaving 5 as the only missing
 * number in the range [0, 5]
 * 
 * Example 2
 * Input: nums = [0, 1, 2, 4, 5, 6]
 * Output: 3
 * Explanation: nums contains 0, 1, 2, 4, 5, 6 thus leaving 3 as the only
 * missing number in the range [0, 6]
 * 
 * Approach 1: using sums with missing number, and sum of array
 * sum of the n numbers is n*(n+1)/2 --> sum1
 * also calculate the sum of the elements in array --> sum2
 * and return the difference between sum1 - sum2
 * 
 */

class Solution {
    public int missingNumber(int[] nums) {
        // Calculate the expected sum of numbers from 0 to n
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;

        // Calculate the actual sum of numbers in the given array
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }

        // Return the difference between the expected sum and the actual sum
        return expectedSum - actualSum;
    }
}