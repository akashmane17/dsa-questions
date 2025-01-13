package Arrays.D_Hard.majorityElement1;

/*
Given an integer array nums of size n, return the majority element of the array.
The majority element of an array is an element that appears more than n/2 times in the array. The array is guaranteed to have a majority element.

Examples:

Input: nums = [7, 0, 0, 1, 7, 7, 2, 7, 7]
Output: 7
Explanation: The number 7 appears 5 times in the 9 sized array

Input: nums = [1, 1, 1, 2, 1, 2]
Output: 1
Explanation: The number 1 appears 4 times in the 6 sized array
*/

public class solution {

    // Method 1: Brute-force approach to find the majority element
    public int majorityElement1(int[] nums) {
        int element = nums[0];

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            int count = 0;

            // Count the occurrences of nums[i]
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }

            // If the count is greater than half the size of the array, it's the majority
            // element
            if (count > nums.length / 2) {
                element = nums[i];
                break;
            }
        }

        return element;
    }

    // Method 2: Boyer-Moore Voting Algorithm to find the majority element
    public int majorityElement2(int[] nums) {
        int count = 0;
        int element = nums[0];

        // Iterate through the array
        for (int num : nums) {
            // If count is 0, choose the current element as the new candidate
            if (count == 0) {
                element = num;
                count++;
            }
            // If the current element is the same as the candidate, increase the count
            else if (element == num) {
                count++;
            }
            // If the current element is different, decrease the count
            else {
                count--;
            }
        }

        // Return the element that is the majority element
        return element;
    }
}
