/**
Given an integer array nums of size n. Return all elements which appear more than n/3 times in the array. The output can be returned in any order.

Examples:
Input: nums = [1, 2, 1, 1, 3, 2]
Output: [1]
Explanation: Here, n / 3 = 6 / 3 = 2.
Therefore the elements appearing 3 or more times is : [1]

Input: nums = [1, 2, 1, 1, 3, 2, 2]
Output: [1, 2]
Explanation: Here, n / 3 = 7 / 3 = 2.
Therefore the elements appearing 3 or more times is : [1, 2]
 */

class Solution {
  // brute
  majorityElementTwo1(nums) {
    let res = new Set();

    for (let i = 0; i < nums.length; i++) {
      let count = 0;

      for (let j = 0; j < nums.length; j++) {
        if (nums[i] === nums[j]) {
          count++;
        }
      }

      if (count > nums.length / 3) {
        res.add(nums[i]);
      }
    }

    const ans = Array.from(res);
    return ans;
  }

  //better version
  majorityElementTwo2(nums) {
    let map = new Map();
    let ans = [];
    let n = nums.length;

    // Count the occurrences of each number
    for (let i = 0; i < nums.length; i++) {
      if (map.has(nums[i])) {
        map.set(nums[i], map.get(nums[i]) + 1); // Correct increment
      } else {
        map.set(nums[i], 1);
      }
    }

    // Check for elements that appear more than n / 3 times
    for (const [key, value] of map) {
      if (value > n / 3) {
        ans.push(key);
      }
    }

    return ans;
  }

  // optimals
  majorityElementTwo(nums) {
    // Size of the array
    let n = nums.length;

    // Counts for elements el1 and el2
    let cnt1 = 0,
      cnt2 = 0;

    /* Initialize Element 1 and 
    Element 2 with INT_MIN value */
    let el1 = Number.MIN_SAFE_INTEGER,
      el2 = Number.MIN_SAFE_INTEGER;

    /* Find the potential candidates using
    Boyer Moore's Voting Algorithm */
    for (let i = 0; i < n; i++) {
      if (cnt1 === 0 && el2 !== nums[i]) {
        cnt1 = 1;
        // Initialize el1 as nums[i]
        el1 = nums[i];
      } else if (cnt2 === 0 && el1 !== nums[i]) {
        cnt2 = 1;
        // Initialize el2 as nums[i]
        el2 = nums[i];
      } else if (nums[i] === el1) {
        // Increment count for el1
        cnt1++;
      } else if (nums[i] === el2) {
        // Increment count for el2
        cnt2++;
      } else {
        // Decrement count for el1
        cnt1--;
        // Decrement count for el2
        cnt2--;
      }
    }

    //Validate the candidates by counting occurrences in nums
    //Reset counts for el1 and el2
    cnt1 = 0;
    cnt2 = 0;

    for (let i = 0; i < n; i++) {
      if (nums[i] === el1) {
        // Count occurrences of el1
        cnt1++;
      }
      if (nums[i] === el2) {
        // Count occurrences of el2
        cnt2++;
      }
    }

    /* Determine the minimum count
    required for a majority element */
    let mini = Math.floor(n / 3) + 1;

    // List of answers
    let result = [];

    /* Add elements to the result array
    if they appear more than n/3 times */
    if (cnt1 >= mini) {
      result.push(el1);
    }
    if (cnt2 >= mini && el1 !== el2) {
      // Avoid adding duplicate if el1 == el2
      result.push(el2);
    }

    //return the majority elements
    return result;
  }
}
