package Arrays.A_Fundamentals.LeftRotateArrayByKplaces;

/**
 * Left Rotate Array by K Places
 * Given an integer array nums and a non-negative integer k, rotate the array to
 * the left by k steps.
 * 
 * Example 1
 * Input: nums = [1, 2, 3, 4, 5, 6], k = 2
 * Output: nums = [3, 4, 5, 6, 1, 2]
 * Explanation: rotate 1 step to the left: [2, 3, 4, 5, 6, 1]
 * rotate 2 steps to the left: [3, 4, 5, 6, 1, 2]
 * 
 * Brute force:
 * Like we solve leftRotateArrayByOnePlace
 * we'll perform same operations for k time
 * to Handle the cases where k is greater than n, we can do k = k%n;
 * 
 * class Solution {
 * public void rotateArray(int[] nums, int k) {
 * int n = nums.length;
 * k = k%n;
 * 
 * for(int i = 0; i < k; i++) {
 * rotateArrayByOne(nums);
 * }
 * }
 * 
 * 
 * public void rotateArrayByOne(int[] nums) {
 * int temp = nums[0];
 * 
 * for(int i=0; i<nums.length-1; i++) {
 * nums[i] = nums[i+1];
 * }
 * 
 * nums[nums.length - 1] = temp;
 * }
 * }
 * 
 * Optimal approach: k = k%n
 * reverse sections of array
 * reverse 0 to k,
 * reverse k to n-1
 * reverse whole array
 */

class Solution {
    public void rotateArray(int[] nums, int k) {
        int n = nums.length;
        // Handle negative K and large K by using modulo
        k = ((k % n) + n) % n;

        if (k == 0) {
            return;
        }

        // Reverse the first k elements
        reverseArray(nums, 0, k - 1);

        // Reverse the last n-k elements
        reverseArray(nums, k, n - 1);

        // Reverse the whole array
        reverseArray(nums, 0, n - 1);
    }

    public void reverseArray(int[] nums, int start, int end) {

        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

    }
}