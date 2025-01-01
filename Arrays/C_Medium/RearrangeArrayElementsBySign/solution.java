package Arrays.C_Medium.RearrangeArrayElementsBySign;

/**
Rearrange array elements by sign

Given an integer array nums of even length consisting of an equal number of positive and negative integers.
Return the answer array in such a way that the given conditions are met:

Every consecutive pair of integers have opposite signs.
For all integers with the same sign, the order in which they were present in nums is preserved.
The rearranged array begins with a positive integer.

Example 1
Input : nums = [2, 4, 5, -1, -3, -4]
Output : [2, -1, 4, -3, 5, -4]
Explanation: The positive number 2, 4, 5 maintain their relative positions and -1, -3, -4 maintain their relative positions

Example 2
Input : nums = [1, -1, -3, -4, 2, 3]
Output : [1, -1, 2, -3, 3, -4]
Explanation: The positive number 1, 2, 3 maintain their relative positions and -1, -3, -4 maintain their relative positions

Solution: 

Initialization:
    res: An empty array to store the rearranged elements.
    p: A pointer to the current position in the array for positive elements.
    n: A pointer to the current position in the array for negative elements.

Rearranging:
    The while loop continues until all elements from the original array are added to the res array.
        Inside the loop:s
            If the last element in the res array is negative or the res array is empty:
                If the current element at p is positive, add it to the res array.
                Increment p to move to the next potential positive element.
            If the last element in the res array is positive:
                If the current element at n is negative, add it to the res array.
                Increment n to move to the next potential negative element.
 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> res = new ArrayList<>(); // List to store the rearranged elements
        int p = 0; // Pointer for positive elements
        int n = 0; // Pointer for negative elements

        // Continue until all elements are added
        while (res.size() < nums.length) {
            if (res.isEmpty() || res.get(res.size() - 1) < 0) {
                // If the last element in 'res' is negative or 'res' is empty,
                // add a positive element
                if (nums[p] > 0) {
                    res.add(nums[p]);
                }
                p++; // Move the positive pointer
            } else {
                // If the last element in 'res' is positive,
                // add a negative element
                if (nums[n] < 0) {
                    res.add(nums[n]);
                }
                n++; // Move the negative pointer
            }
        }

        // Convert List<Integer> to int[] for output
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }

        return result;
    }
}
