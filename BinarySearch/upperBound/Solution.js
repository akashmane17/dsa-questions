/*
Upper Bound

Given a sorted array of nums and an integer x, write a program to find the upper bound of x. The upper bound algorithm finds the first or the smallest index in a sorted array where the value at that index is greater than a given key i.e. x.
If no such index is found, return the size of the array.

Examples:

Input : n= 4, nums = [1,2,2,3], x = 2
Output:3
Explanation: Index 3 is the smallest index such that arr[3] > x.

Input : n = 5, nums = [3,5,8,15,19], x = 9
Output: 3
Explanation: Index 3 is the smallest index such that arr[3] > x.
*/

class Solution {
  upperBound(nums, x) {
    let n = nums.length;
    let low = 0;
    let high = n - 1;

    let ans = n;

    while (low <= high) {
      let mid = Math.floor((low + high) / 2);

      // if element is greater update the ans with mid index, and update the high to search on left sideF
      if (nums[mid] > x) {
        ans = mid;
        high = mid - 1;
      }
      // If element is smaller, update the low to search on the right sid
      else {
        low = mid + 1;
      }
    }

    return ans;
  }
}
