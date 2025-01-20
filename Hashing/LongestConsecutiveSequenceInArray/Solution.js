/*
Longest Consecutive Sequence in an Array

Given an array nums of n integers, return the length of the longest sequence of consecutive integers. The integers in this sequence can appear in any order.

Examples:
Input: nums = [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest sequence of consecutive elements in the array is [1, 2, 3, 4], which has a length of 4. This sequence can be formed regardless of the initial order of the elements in the array.

Input: nums = [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]
Output: 9
Explanation: The longest sequence of consecutive elements in the array is [0, 1, 2, 3, 4, 5, 6, 7, 8], which has a length of 9. 

*/

/*
Brute Force: O(n^2)
in each iteration pick an element (x), look for its next consecutive value using linear search
if value exists increment the count and continue looking for next values until there are none
then compare the count with current longest and store greater value in longest variable
*/
class Solution {
  linearSearch(nums, num) {
    const n = nums.length;
    // Traverse through the array
    for (let i = 0; i < n; i++) {
      if (nums[i] === num) return true;
    }
    return false;
  }

  longestConsecutive(nums) {
    // If the array is empty
    if (nums.length === 0) {
      return 0;
    }
    const n = nums.length;
    // Initialize the longest sequence length
    let longest = 1;

    for (let i = 0; i < nums.length; i++) {
      let x = nums[i];
      let cnt = 1;
      while (this.linearSearch(nums, x + 1)) {
        x += 1;
        cnt += 1;
      }
      longest = Math.max(longest, cnt);
    }
    return longest;
  }
}

/*
Better: O(nLOGn) + O(n)
sort the array, so that the consecutive ones comes closer
keep track of last smaller element
if lastSmall is == current - 1 then increment the count, and update lastSmall
if lastSmall is != current then update lastSmall and set count = 1;
if the lastSmall == current the we'll skip
keep comparing cnt with longest to store the greater value
*/
class Solution2 {
  longestConsecutive(nums) {
    // If the array is empty
    if (nums.length === 0) {
      return 0;
    }

    nums.sort((a, b) => a - b);

    // Initialize the longest sequence length
    let longest = 0;
    let lastSmaller = Number.MIN_SAFE_INTEGER;
    let cnt = 0;

    for (let i = 0; i < nums.length; i++) {
      if (nums[i] - 1 === lastSmaller) {
        cnt += 1;
        lastSmaller = nums[i];
      } else if (nums[i] !== lastSmaller) {
        cnt = 1;
        lastSmaller = nums[i];
      }
      longest = Math.max(longest, cnt);
    }

    return longest;
  }
}

/*
Optimal: 
Time: O(n)
Space: O(n)
redefine bruteforce approach
instead of linear search, create a set, add all elements to set
and check if the next element is present in set if it does then increment the count
Also before start searching making sure that the current element is the first one in its consecutive sequence
using this conditon if (!set.has(nums[i] - 1)) {
*/
class Solution3 {
  longestConsecutive(nums) {
    // If the array is empty
    if (nums.length === 0) return 0;
    const set = new Set();

    for (let num of nums) {
      set.add(num);
    }

    // Initialize the longest sequence length
    let longest = 0;

    for (let i = 0; i < nums.length; i++) {
      if (!set.has(nums[i] - 1)) {
        let cnt = 1;
        let x = nums[i];
        while (set.has(x + 1)) {
          cnt += 1;
          x += 1;
        }
        longest = Math.max(longest, cnt);
      }
    }

    return longest;
  }
}
