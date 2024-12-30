/**
Left Rotate Array by K Places 
Given an integer array nums and a non-negative integer k, rotate the array to the left by k steps.

Example 1
Input: nums = [1, 2, 3, 4, 5, 6], k = 2
Output: nums = [3, 4, 5, 6, 1, 2]
Explanation: rotate 1 step to the left: [2, 3, 4, 5, 6, 1]
rotate 2 steps to the left: [3, 4, 5, 6, 1, 2]

Brute force:
Like we solve leftRotateArrayByOnePlace
we'll perform same operations for k time
to Handle the cases where k is greater than n, we can do k = k%n; 

class Solution {
    rotateArrayByOne(nums) {
        let temp = nums[0];

        for(let i=0; i < nums.length-1; i++) {
            nums[i] = nums[i+1];
        }

        nums[nums.length - 1] = temp;
    }

    rotateArray(nums, k) {
        let n = nums.length;
        k = k%n;

        for(let i = 0; i < k; i++) {
            this.rotateArrayByOne(nums);
        }
    }

}


Optimal approach: k = k%n
    reverse sections of array
    reverse 0 to k,
    reverse k to n-1
    reverse whole array
 */

class Solution {
  rotateArray(nums, k) {
    const n = nums.length;
    // Handle negative K and large K by using modulo
    k = ((k % n) + n) % n;

    if (k === 0) {
      return;
    }

    // Reverse the first k elements
    this.reverseArray(nums, 0, k - 1);

    // Reverse the last n-k elements
    this.reverseArray(nums, k, n - 1);

    // Reverse the whole array
    this.reverseArray(nums, 0, n - 1);
  }

  reverseArray(nums, start, end) {
    while (start < end) {
      [nums[start], nums[end]] = [nums[end], nums[start]];
      start++;
      end--;
    }
  }
}
