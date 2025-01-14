package Arrays.D_Hard.reversePairs;

/*
Given an integer array nums. Return the number of reverse pairs in the array.
An index pair (i, j) is called a reverse pair if:
    0 <= i < j < nums.length
    nums[i] > 2 * nums[j].

Examples:

Input: nums = [6, 4, 1, 2, 7]
Output: 3
Explanation: The reverse pairs are:
(0, 2) : nums[0] = 6, nums[2] = 1, 6 > 2 * 1
(0, 3) : nums[0] = 6, nums[3] = 2, 6 > 2 * 2
(1, 2) : nums[1] = 4, nums[2] = 1, 4 > 2 * 1

Input: nums = [5, 4, 4, 3, 3]
Output: 0
Explanation: No pairs satisfy both the conditons.
*/

// Brute force

class Solution1 {
    int reversePairs(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i < j && nums[i] > 2 * nums[j]) {
                    count++;
                }
            }
        }

        return count;
    }
}

class Solution {
    // Function to merge two sorted halves of the array
    private void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1]; // Temporary array to hold the merged elements
        int left = low; // Pointer for the left half
        int right = mid + 1; // Pointer for the right half
        int index = 0; // Index for the temp array

        // Merge the two halves by comparing elements
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp[index++] = nums[left++];
            } else {
                temp[index++] = nums[right++];
            }
        }

        // Add any remaining elements from the left half
        while (left <= mid) {
            temp[index++] = nums[left++];
        }

        // Add any remaining elements from the right half
        while (right <= high) {
            temp[index++] = nums[right++];
        }

        // Copy the sorted elements from the temporary array back to the original array
        System.arraycopy(temp, 0, nums, low, temp.length);
    }

    // Function to count the number of reverse pairs in the current portion of the
    // array
    private int countPairs(int[] nums, int low, int mid, int high) {
        int right = mid + 1; // Pointer to traverse the right half
        int count = 0; // Variable to keep track of the count of reverse pairs

        // Traverse through the left half of the array
        for (int i = low; i <= mid; i++) {
            // While the current element in the left half is greater than twice the element
            // in the right half
            while (right <= high && nums[i] > 2L * nums[right]) {
                right++;
            }
            // Count the number of valid reverse pairs
            count += right - (mid + 1);
        }

        return count;
    }

    // Recursive function to perform merge sort and count reverse pairs
    private int mergeSort(int[] nums, int low, int high) {
        if (low >= high)
            return 0;

        int mid = low + (high - low) / 2;
        int count = 0;

        // Recursively sort the left half and count reverse pairs
        count += mergeSort(nums, low, mid);

        // Recursively sort the right half and count reverse pairs
        count += mergeSort(nums, mid + 1, high);

        // Count the reverse pairs that span across the two halves
        count += countPairs(nums, low, mid, high);

        // Merge the two sorted halves
        merge(nums, low, mid, high);

        return count;
    }

    // Main function to calculate the number of reverse pairs in the array
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    // Main method to test the function
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 1, 3, 2, 3, 1 };
        System.out.println("Number of reverse pairs: " + solution.reversePairs(nums));
    }
}