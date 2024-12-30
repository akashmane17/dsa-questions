package Arrays.B_LogicBuilding.UnionOfSortedArrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two sorted arrays nums1 and nums2, return an array that contains the
 * union of these two arrays.
 * The elements in the union must be in ascending order.
 *
 * The union of two arrays is an array where all values are distinct and are
 * present
 * in either the first array, the second array, or both.
 *
 * Example 1
 * Input: nums1 = [1, 2, 3, 4, 5], nums2 = [1, 2, 7]
 * Output: [1, 2, 3, 4, 5, 7]
 * Explanation: The elements 1, 2 are common to both, 3, 4, 5 are from nums1 and
 * 7 is from nums2
 *
 * Example 2
 * Input: nums1 = [3, 4, 6, 7, 9, 9], nums2 = [1, 5, 7, 8, 8]
 * Output: [1, 3, 4, 5, 6, 7, 8, 9]
 * Explanation: The element 7 is common to both, 3, 4, 6, 9 are from nums1 and
 * 1, 5, 8 is from nums2
 *
 * Two pointer approach:
 *
 * 1. Initialize:
 * - `union`: An empty array to store the union of the two arrays.
 * - `i` and `j`: Pointers for the current indices in `nums1` and `nums2`,
 * respectively.
 * - `n` and `m`: Lengths of `nums1` and `nums2`, respectively.
 *
 * 2. Main Loop:
 * - While both `i` and `j` are within the bounds of their respective arrays:
 *
 * - Case 1: If `nums1[i]` is less than or equal to `nums2[j]`:
 * - Check if `nums1[i]` is not already the last element in the `union` array.
 * This prevents duplicates.
 * - If `nums1[i]` is unique, add it to the `union` array.
 * - Increment `i`.
 *
 * - Case 2: If `nums2[j]` is smaller:
 * - Check if `nums2[j]` is not already the last element in the `union` array.
 * - If `nums2[j]` is unique, add it to the `union` array.
 * - Increment `j`.
 *
 * Handle Remaining Elements:
 * - Iterate through the remaining elements in `nums1` (if any)
 * and add them to the `union` array if they are unique.
 * - Iterate through the remaining elements in `nums2` (if any)
 * and add them to the `union` array if they are unique.
 *
 * return the union array
 */

class Solution {
    public int[] unionArray(int[] nums1, int[] nums2) {
        List<Integer> UnionList = new ArrayList<Integer>();
        int i = 0, j = 0;
        int n = nums1.length;
        int m = nums2.length;

        while (i < n && j < m) {
            // Case 1 and 2
            if (nums1[i] <= nums2[j]) {
                // If UnionList is empty
                // or the last element in UnionList is not the same as nums1[i]
                if (UnionList.isEmpty() || UnionList.get(UnionList.size() - 1) != nums1[i]) {
                    UnionList.add(nums1[i]);
                }
                i++;
            }
            // Case 3
            else {
                // If UnionList is empty
                // or the last element in UnionList is not the same as nums1[i]
                if (UnionList.isEmpty() || UnionList.get(UnionList.size() - 1) != nums2[j]) {
                    UnionList.add(nums2[j]);
                }
                j++;
            }
        }

        // Add remaining elements of nums1, if any
        while (i < n) {
            // If UnionList is empty
            // or the last element in UnionList is not the same as nums1[i]
            if (UnionList.isEmpty() || UnionList.get(UnionList.size() - 1) != nums1[i]) {
                UnionList.add(nums1[i]);
            }
            i++;
        }

        // Add remaining elements of nums2, if any
        while (j < m) {
            // If UnionList is empty
            // or the last element in UnionList is not the same as nums1[i]
            if (UnionList.isEmpty() || UnionList.get(UnionList.size() - 1) != nums2[j]) {
                UnionList.add(nums2[j]);
            }
            j++;
        }

        // Convert List<Integer> to int[]
        int[] Union = new int[UnionList.size()];
        for (int k = 0; k < UnionList.size(); k++) {
            Union[k] = UnionList.get(k);
        }

        return Union;
    }
}