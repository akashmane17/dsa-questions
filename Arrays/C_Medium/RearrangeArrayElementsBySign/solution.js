class Solution {
  rearrangeArray(nums) {
    let res = []; // Resultant array to store the rearranged elements
    let p = 0; // Pointer for positive elements
    let n = 0; // Pointer for negative elements

    while (res.length < nums.length) {
      // Continue until all elements are added to the result

      // If the last element in 'res' is negative or 'res' is empty,
      // we need to add a positive element
      if (res.length === 0 || res[res.length - 1] < 0) {
        if (nums[p] > 0) {
          // If the current positive element is valid
          res.push(nums[p]);
        }
        p++; // Move the positive pointer forward
      } else {
        // If the last element in 'res' is positive,
        // we need to add a negative element
        if (nums[n] < 0) {
          // If the current negative element is valid
          res.push(nums[n]);
        }
        n++; // Move the negative pointer forward
      }
    }

    return res;
  }
}
