/**
 Second Largest Element

 Given an array of integers nums, return the second-largest element in the array. If the second-largest element does not exist, return -1.

Example 1
Input: nums = [8, 8, 7, 6, 5]
Output: 7
Explanation: The largest value in nums is 8, the second largest is 7

Example 2
Input: nums = [10, 10, 10, 10, 10]
Output: -1
Explanation: The only value in nums is 10, so there is no second largest value, thus -1 is returned

Brute force: 
sort the array
iterate over the array from the last element and iterate till it reaches the 
element which is not equal to the last element, that'll be the second large element

Optimal: 
Initialize largest and secondLargest variables to Number.MIN_VALUE.
Traverse the array.
For each element:
    If the current element is greater than largest:
        Update secondLargest with the current largest.
        Update largest with the current element.

    If the current element is greater than secondLargest and not equal to largest:
        Update secondLargest with the current element.

Return:
    If secondLargest is not equal to Number.MIN_VALUE, return secondLargest.
    Otherwise, return -1 (indicating no second-largest element found).


 * Time complexity : O(n)
 * Space complexity : O(1)
*/

class Solution {
  secondLargestElement(nums) {
    let n = nums.length;
    if (n === 1) return -1;

    let largest = Number.MIN_VALUE;
    let secondLargest = Number.MIN_VALUE;

    for (let i = 0; i < n; i++) {
      if (nums[i] > largest) {
        secondLargest = largest;
        largest = nums[i];
      } else if (nums[i] > secondLargest && nums[i] !== largest) {
        secondLargest = nums[i];
      }
    }

    return secondLargest !== Number.MIN_VALUE ? secondLargest : -1;
  }
}
