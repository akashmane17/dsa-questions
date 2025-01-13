/** Brute Force version
class Solution {
    numberOfInversions(nums) {
        // Size of the array
        const n = nums.length;
        let count = 0;
        
        for (let i = 0; i < n; i++) {
            for (let j = 0; j < n; j++) {
                if (nums[i] > nums[j] && i < j) count++;
            }
        }
        
        return count;
    }
}
*/

class Solution {
  /* Merge function to count 
    inversions and merge sorted halves */
  merge(arr, low, mid, high) {
    // Temporary array for merging
    const temp = [];

    // Starting indices of left and right halves
    let left = low;
    let right = mid + 1;

    // Count variable to count the pairs
    let cnt = 0;

    // Merge sorted halves into temp array
    while (left <= mid && right <= high) {
      if (arr[left] <= arr[right]) {
        temp.push(arr[left]);
        left++;
      } else {
        temp.push(arr[right]);

        // Count inversions
        cnt += mid - left + 1;

        right++;
      }
    }

    // Copy remaining elements of left half
    while (left <= mid) {
      temp.push(arr[left]);
      left++;
    }

    // Copy remaining elements of right half
    while (right <= high) {
      temp.push(arr[right]);
      right++;
    }

    /* Copy elements from temp 
        array back to original array */
    for (let i = low; i <= high; i++) {
      arr[i] = temp[i - low];
    }

    // Return the count of inversions
    return cnt;
  }

  // Merge sort function to recursively sort and count inversions
  mergeSort(arr, low, high) {
    let cnt = 0;
    if (low < high) {
      const mid = low + Math.floor((high - low) / 2);

      // Sort left half
      cnt += this.mergeSort(arr, low, mid);

      // Sort right half
      cnt += this.mergeSort(arr, mid + 1, high);

      // Merge and count inversions
      cnt += this.merge(arr, low, mid, high);
    }
    return cnt;
  }

  numberOfInversions(nums) {
    // Size of the array
    const n = nums.length;

    // Count the number of pairs
    return this.mergeSort(nums, 0, n - 1);
  }
}
