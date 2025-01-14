/*
Given an integer array nums. Return the number of reverse pairs in the array.
An index pair (i, j) is called a reverse pair if:
    0 <= i < j < nums.length
    nums[i] > 2 * nums[j].

Examples:

Input: nums = [6, 4, 1, 2, 7]
Output: 3
Explanation: The reverse pairs are:
(0, 2) : nums[0] = 6, nums[2] = 1, 6 > 2 * 1
(0, 3) : nums[0] = 6, nums[3] = 2, 6 > 2 * 2
(1, 2) : nums[1] = 4, nums[2] = 1, 4 > 2 * 1

Input: nums = [5, 4, 4, 3, 3]
Output: 0
Explanation: No pairs satisfy both the conditons.
*/

// Brute force
class Solution1 {
  reversePairs(nums) {
    let count = 0;

    for (let i = 0; i < nums.length; i++) {
      for (let j = 0; j < nums.length; j++) {
        if (i < j && nums[i] > 2 * nums[j]) {
          count++;
        }
      }
    }

    return count;
  }
}

class Solution {
  // Function to merge two sorted halves of the array
  merge(nums, low, mid, high) {
    let temp = []; // Temporary array to hold the merged elements
    let left = low; // Pointer for the left half
    let right = mid + 1; // Pointer for the right half

    // Merge the two halves by comparing elements
    while (left <= mid && right <= high) {
      if (nums[left] <= nums[right]) {
        temp.push(nums[left]); // Add smaller element from the left half
        left++;
      } else {
        temp.push(nums[right]); // Add smaller element from the right half
        right++;
      }
    }

    // Add any remaining elements from the left half
    while (left <= mid) {
      temp.push(nums[left++]);
    }

    // Add any remaining elements from the right half
    while (right <= high) {
      temp.push(nums[right++]);
    }

    // Copy the sorted elements from the temporary array back to the original array
    for (let i = low; i <= high; i++) {
      nums[i] = temp[i - low];
    }
  }

  // Function to count the number of reverse pairs in the current portion of the array
  countPairs(nums, low, mid, high) {
    let right = mid + 1; // Pointer to traverse the right half
    let cnt = 0; // Variable to keep track of the count of reverse pairs

    // Traverse through the left half of the array
    for (let i = low; i <= mid; i++) {
      // While the current element in the left half is greater than twice the element in the right half,
      // increment the right pointer
      while (right <= high && nums[i] > 2 * nums[right]) {
        right++;
      }

      // The number of reverse pairs is the number of elements in the right half that satisfy the condition
      cnt += right - (mid + 1);
    }

    // Return the count of reverse pairs
    return cnt;
  }

  // Recursive function to perform merge sort and count reverse pairs
  mergeSort(nums, low, high) {
    let count = 0; // Variable to keep track of the total count of reverse pairs

    // Base case: If the subarray has more than one element, proceed with sorting
    if (low < high) {
      const mid = low + Math.floor((high - low) / 2); // Calculate the middle index

      // Recursively sort the left half and count reverse pairs
      count += this.mergeSort(nums, low, mid);

      // Recursively sort the right half and count reverse pairs
      count += this.mergeSort(nums, mid + 1, high);

      // Count the reverse pairs that span across the two halves
      count += this.countPairs(nums, low, mid, high);

      // Merge the two sorted halves
      this.merge(nums, low, mid, high);
    }

    // Return the total count of reverse pairs for the current subarray
    return count;
  }

  // Main function to calculate the number of reverse pairs in the array
  reversePairs(nums) {
    // Call the mergeSort function with the entire array and return the result
    return this.mergeSort(nums, 0, nums.length - 1);
  }
}
