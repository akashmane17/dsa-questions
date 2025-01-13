package Arrays.D_Hard.countInversions;
/*
Given an integer array nums. Return the number of inversions in the array.

Two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.

    It indicates how close an array is to being sorted.
    A sorted array has an inversion count of 0.
    An array sorted in descending order has maximum inversion.

Examples:

Input: nums = [2, 3, 7, 1, 3, 5]
Output: 5
Explanation: The responsible indexes are:
nums[0], nums[3], values: 2 > 1 & indexes: 0 < 3
nums[1], nums[3], values: 3 > 1 & indexes: 1 < 3
nums[2], nums[3], values: 7 > 1 & indexes: 2 < 3
nums[2], nums[4], values: 7 > 3 & indexes: 2 < 4
nums[2], nums[5], values: 7 > 5 & indexes: 2 < 5

*/

// Bruteforce
class Solution2 {
    int numberOfInversions(int[] nums) {
        // Size of the array
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[i] > nums[j] && i < j)
                    count++;
            }
        }

        return count;
    }
}

public class Solution {

    // Merge function to count inversions and merge sorted halves
    private int merge(int[] arr, int low, int mid, int high) {
        // Temporary array for merging
        int[] temp = new int[high - low + 1];

        // Starting indices of left and right halves
        int left = low;
        int right = mid + 1;
        int index = 0;

        // Count variable to count the pairs
        int cnt = 0;

        // Merge sorted halves into temp array
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[index++] = arr[left++];
            } else {
                temp[index++] = arr[right++];

                // Count inversions
                cnt += (mid - left + 1);
            }
        }

        // Copy remaining elements of left half
        while (left <= mid) {
            temp[index++] = arr[left++];
        }

        // Copy remaining elements of right half
        while (right <= high) {
            temp[index++] = arr[right++];
        }

        // Copy elements from temp array back to original array
        for (int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }

        // Return the count of inversions
        return cnt;
    }

    // Merge sort function to recursively sort and count inversions
    private int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;

        if (low < high) {
            int mid = low + (high - low) / 2;

            // Sort left half
            cnt += mergeSort(arr, low, mid);

            // Sort right half
            cnt += mergeSort(arr, mid + 1, high);

            // Merge and count inversions
            cnt += merge(arr, low, mid, high);
        }

        return cnt;
    }

    // Function to count the number of inversions in the array
    public int numberOfInversions(int[] nums) {
        int n = nums.length;
        return mergeSort(nums, 0, n - 1);
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = { 8, 4, 2, 1 };

        System.out.println("Number of Inversions: " + solution.numberOfInversions(nums));
    }
}
