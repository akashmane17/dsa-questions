/**
 Given an integer array nums and an integer target. Return all quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
·      a, b, c, d are all distinct valid indices of nums.
·      nums[a] + nums[b] + nums[c] + nums[d] == target.

Notice that the solution set must not contain duplicate quadruplets. One element can be a part of multiple quadruplets. The output and the quadruplets can be returned in any order.

Examples:
Input: nums = [1, -2, 3, 5, 7, 9], target = 7
Output: [[-2, 1, 3, 5]]
Explanation: nums[1] + nums[0] + nums[2] + nums[3] = 7

Input: nums = [7, -7, 1, 2, 14, 3], target = 9
Output: []
Explanation: No quadruplets are present which add upto 9
 */

class Solution {
  // Brute force approach
  fourSum(nums, target) {
    let set = new Set();

    let n = nums.length;

    for (let i = 0; i < n - 3; i++) {
      for (let j = i + 1; j < n - 2; j++) {
        for (let k = j + 1; k < n - 1; k++) {
          for (let l = k + 1; l < n; l++) {
            if (nums[i] + nums[j] + nums[k] + nums[l] === target) {
              let temp = [nums[i], nums[j], nums[k], nums[l]];

              // sort the array before storing
              temp.sort((a, b) => a - b);

              set.add(temp.join(","));
            }
          }
        }
      }
    }

    // Convert set to array of arrays (unique triplets)
    // convert string "2,-2,0,1", to ["2", "-2", "0", "1"], then parse these string values to Int [2, -2, 0, 1]
    let ans = Array.from(set).map((qSet) =>
      qSet.split(",").map((num) => parseInt(num))
    );

    //Return the ans
    return ans;
  }
}
