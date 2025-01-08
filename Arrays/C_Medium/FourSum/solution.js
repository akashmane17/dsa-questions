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

  // Optimal way
  fourSum2(nums, target) {
    // Sort the array to make it easier to avoid duplicates and use two-pointer technique
    nums.sort((a, b) => a - b);

    // Initialize the result array to store unique quadruplets
    let result = [];

    // Get the length of the array
    let n = nums.length;

    // Loop to fix the first number
    for (let i = 0; i < n - 3; i++) {
      // Skip duplicate values for the first number
      if (i > 0 && nums[i] === nums[i - 1]) continue;

      // Loop to fix the second number
      for (let j = i + 1; j < n - 2; j++) {
        // Skip duplicate values for the second number
        if (j > i + 1 && nums[j] === nums[j - 1]) continue;

        // Use two pointers to find the remaining two numbers
        let left = j + 1;
        let right = n - 1;

        // Two-pointer approach to find quadruplets
        while (left < right) {
          // Calculate the sum of the four numbers
          let sum = nums[i] + nums[j] + nums[left] + nums[right];

          // If the sum matches the target, add the quadruplet to the result
          if (sum === target) {
            result.push([nums[i], nums[j], nums[left], nums[right]]);

            // Move the left pointer to skip duplicate values
            while (left < right && nums[left] === nums[left + 1]) left++;
            // Move the right pointer to skip duplicate values
            while (left < right && nums[right] === nums[right - 1]) right--;

            // Move both pointers to continue searching for other quadruplets
            left++;
            right--;
          }
          // If the sum is less than the target, move the left pointer to increase the sum
          else if (sum < target) {
            left++;
          }
          // If the sum is greater than the target, move the right pointer to decrease the sum
          else {
            right--;
          }
        }
      }
    }

    // Return the list of unique quadruplets
    return result;
  }
}
