package Arrays.D_Hard.maximumProductSubarrayInArray;

/*
Maximum Product Subarray in an Array

Given an integer array nums. Find the subarray with the largest product, and return the product of the elements present in that subarray.
A subarray is a contiguous non-empty sequence of elements within an array.

Examples:
Input: nums = [4, 5, 3, 7, 1, 2]
Output: 840
Explanation: The largest product is given by the whole array itself

Input: nums = [-5, 0, -2]
Output: 0
Explanation: The largest product is achieved with the following subarrays [0], [-5, 0], [0, -2], [-5, 0, 2].

Approach:
    Traverse the array from the start.
    Keep track of the running product of elements.
    If the running product becomes the largest so far, update the maximum product.
    If a 0 is encountered, reset the product to 1 because a subarray starting after 0 is treated as a new one.

Problem with This Approach:
    If the array has an odd number of negative elements, their product will be negative.
    To fix this, we need to remove one negative element so that the remaining product is positive.

How to Handle This:
    Since the subarray must stay continuous, we can only remove either the first or the last negative element.
    To check both possibilities, traverse the array twice: once from the start and once from the end.
    This ensures we find the maximum product subarray.
*/

class Solution {
    public int maxProduct(int[] nums) {
        // Initialize the result to the smallest possible value
        int result = Integer.MIN_VALUE;

        // Initialize variables for prefix and suffix products
        int prefixProd = 1;
        int suffixProd = 1;

        // Get the length of the input array
        int n = nums.length;

        // Iterate through the array to calculate the maximum product
        for (int i = 0; i < n; i++) {
            // Multiply the current element to the prefix product
            prefixProd *= nums[i];

            // Multiply the corresponding element from the end to the suffix product
            suffixProd *= nums[n - i - 1];

            // Update the result with the maximum of current prefix or suffix product
            result = Math.max(result, Math.max(prefixProd, suffixProd));

            // Reset prefix product to 1 if it becomes 0
            if (prefixProd == 0)
                prefixProd = 1;

            // Reset suffix product to 1 if it becomes 0
            if (suffixProd == 0)
                suffixProd = 1;
        }

        // Handle the case where the result is -0 (return 0 instead of -0)
        return result;
    }
}
