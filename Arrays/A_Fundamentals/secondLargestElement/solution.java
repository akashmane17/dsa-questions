package Arrays.A_Fundamentals.secondLargestElement;

/**
 * Second Largest Element
 * 
 * Given an array of integers nums, return the second-largest element in the
 * array. If the second-largest element does not exist, return -1.
 * 
 * Example 1
 * Input: nums = [8, 8, 7, 6, 5]
 * Output: 7
 * Explanation: The largest value in nums is 8, the second largest is 7
 * 
 * Example 2
 * Input: nums = [10, 10, 10, 10, 10]
 * Output: -1
 * Explanation: The only value in nums is 10, so there is no second largest
 * value, thus -1 is returned
 * 
 * Brute force:
 * sort the array
 * iterate over the array from the last element and iterate till it reaches the
 * element which is not equal to the last element, that'll be the second large
 * element
 * 
 * Optimal:
 * Initialize largest and secondLargest variables to Integer.MIN_VALUE.
 * Traverse the array.
 * For each element:
 * If the current element is greater than largest:
 * Update secondLargest with the current largest.
 * Update largest with the current element.
 * 
 * If the current element is greater than secondLargest and not equal to
 * largest:
 * Update secondLargest with the current element.
 * 
 * Return:
 * If secondLargest is not equal to Integer.MIN_VALUE, return secondLargest.
 * Otherwise, return -1 (indicating no second-largest element found).
 * 
 * Time complexity : O(n)
 * Space complexity : O(1)
 * 
 */

class Solution {
    public int secondLargestElement(int[] nums) {
        int n = nums.length;

        // Check if the array has less than 2 elements
        if (n < 2) {
            return -1;
        }

        /*
         * Initialize variables to store the
         * largest and second largest elements
         */
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (nums[i] > largest) {
                secondLargest = largest;
                largest = nums[i];
            } else if (nums[i] > secondLargest && nums[i] != largest) {
                secondLargest = nums[i];
            }
        }

        // Return the second largest element
        return secondLargest == Integer.MIN_VALUE ? -1 : secondLargest;
    }
}
