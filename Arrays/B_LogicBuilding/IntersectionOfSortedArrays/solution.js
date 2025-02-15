/**
Given two sorted arrays nums1 and nums2, return an array containing the intersection of these two arrays.
The intersection of two arrays is an array where all values are present in both arrays.

Example 1
Input: nums1 = [1, 2, 2, 3, 5], nums2 = [1, 2, 7]
Output: [1, 2]
Explanation: The elements 1, 2 are the only elements present in both nums1 and nums2

Example 2
Input: nums1 = [1, 2, 2, 3], nums2 = [4, 5, 7]
Output: []
Explanation: No elements appear in both nums1 and nums2

approach: two pointer

initialization: i for tracking nums1, j for tracking num2,

loop: while i is less than num1.length and j is less than num2.length;

case1: if nums1[i] is equal to nums2[j] add that element in ans array increment both i and j by 1

case 2 if nums1[i] is greater than nums2[j] increment j by 1, to find greater element in nums2

case 3 where nums2[j] will be greater than nums1[i], here increment i by 1, to find greater element in nums1 array

*/

class Solution {
  intersectionArray(nums1, nums2) {
    let i = 0;
    let j = 0;
    let n1 = nums1.length;
    let n2 = nums2.length;

    let ans = [];

    while (i < n1 && j < n2) {
      if (nums1[i] === nums2[j]) {
        ans.push(nums1[i]);
        i++;
        j++;
      } else if (nums1[i] > nums2[j]) {
        j++;
      } else {
        i++;
      }
    }

    return ans;
  }
}
