/**
 * Merge two sorted arrays without extra space
 * 
 * Given two integer arrays nums1 and nums2. Both arrays are sorted in
 * non-decreasing order.
 * Merge both the arrays into a single array sorted in non-decreasing order.
 * 
 * The final sorted array should be stored inside the array nums1 and it should
 * be done in-place.
 * nums1 has a length of m + n, where the first m elements denote the elements
 * of nums1 and rest are 0s.
 * nums2 has a length of n.
 * 
 * Examples:
 * 
 * Input: nums1 = [-5, -2, 4, 5], nums2 = [-3, 1, 8]
 * Output: [-5, -3, -2, 1, 4, 5, 8]
 * Explanation: The merged array is: [-5, -3, -2, 1, 4, 5, 8], where [-5, -2, 4,
 * 5] are from nums1 and [-3, 1, 8] are from nums2
 * 
 * Input: nums1 = [0, 2, 7, 8], nums2 = [-7, -3, -1]
 * Output: [-7, -3, -1, 0, 2, 7, 8]
 * Explanation: The merged array is: [-7, -3, -1, 0, 2, 7, 8], where [0, 2, 7,
 * 8] are from nums1 and [-7, -3, -1] are from nums2F
 */

class Solution {
    // Brute force approach
    // Create a new array of size m + n
    // We'll compare elements of nums1 and nums2 using two-pointer method
    // Store the smaller one first
    // At the end, store the remaining elements from nums1 or nums2
    public int[] merge1(int[] nums1, int m, int[] nums2, int n) {
        // Pointer for nums1
        int i = 0;
        // Pointer for nums2
        int j = 0;

        int[] res = new int[m + n];
        int index = 0;

        // While pointers i and j are not crossing their respective array bounds
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                res[index++] = nums1[i++];
            } else {
                res[index++] = nums2[j++];
            }
        }

        // Store remaining elements from nums1
        while (i < m) {
            res[index++] = nums1[i++];
        }

        // Store remaining elements from nums2
        while (j < n) {
            res[index++] = nums2[j++];
        }

        return res;
    }

    // Optimal approach: using two pointers
    // Keep the pointer i and j at the end of nums1 and nums2
    // Compare and store the greater value from nums1[i] and nums2[j] at index k (k
    // = m + n - 1)
    // Lastly, store all the elements from nums2 to nums1 from index k if there are
    // any left
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // Pointer for nums1
        int j = n - 1; // Pointer for nums2
        int k = m + n - 1; // Pointer for the final position in nums1

        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // Store remaining elements from nums2
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
