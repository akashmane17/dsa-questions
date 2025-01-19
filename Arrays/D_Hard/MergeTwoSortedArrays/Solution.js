/**
Merge two sorted arrays without extra space

Given two integer arrays nums1 and nums2. Both arrays are sorted in non-decreasing order.
Merge both the arrays into a single array sorted in non-decreasing order.

    The final sorted array should be stored inside the array nums1 and it should be done in-place.
    nums1 has a length of m + n, where the first m elements denote the elements of nums1 and rest are 0s.
    nums2 has a length of n.

Examples:

Input: nums1 = [-5, -2, 4, 5], nums2 = [-3, 1, 8]
Output: [-5, -3, -2, 1, 4, 5, 8]
Explanation: The merged array is: [-5, -3, -2, 1, 4, 5, 8], where [-5, -2, 4, 5] are from nums1 and [-3, 1, 8] are from nums2

Input: nums1 = [0, 2, 7, 8], nums2 = [-7, -3, -1]
Output: [-7, -3, -1, 0, 2, 7, 8]
Explanation: The merged array is: [-7, -3, -1, 0, 2, 7, 8], where [0, 2, 7, 8] are from nums1 and [-7, -3, -1] are from nums2F
 */

class Solution {
  /*
    Brute force approach
    create a new array of size m+n
    we'll compare elements of nums1 and nums2 using two pointer method
    store the smaller one first
    at the end store the remaining elements from nums1 or nums2
    */
  merge1(nums1, m, nums2, n) {
    // pointer for nums1
    let i = 0,
      // pointer for nums2
      j = 0;

    let res = [];

    // while pointer i and j are not crossing their respectice array bonds
    while (i < m && j < n) {
      if (nums1[i] <= nums2[j]) {
        res.push(nums1[i++]);
      } else {
        res.push(nums2[j++]);
      }
    }

    // store remaining elements from nums1
    while (i < m) {
      res.push(nums1[i++]);
    }

    // store remaining elements from nums2
    while (j < n) {
      res.push(nums2[j++]);
    }

    return res;
  }

  /*
  Optimal approach: using two pointer
  keep the pointer i and j at the end of the nums1 and nums2
  compare and store greater value from nums1[i] and nums2[j] at index k, (k = m+n-1)
  atlast store all the elements from nums2 to nums1 from index k if there are any left
  */
  merge2(nums1, m, nums2, n) {
    let i = m - 1;
    let j = n - 1;

    let k = m + n - 1;

    while (i >= 0 && j >= 0) {
      if (nums1[i] >= nums2[j]) {
        nums1[k] = nums1[i];
        i--;
        k--;
      } else {
        nums1[k] = nums2[j];
        j--;
        k--;
      }
    }

    while (j >= 0) {
      nums1[k] = nums2[j];
      j--;
      k--;
    }
  }
}
