/*
Find Nth root of a number
Given two numbers N and M, find the Nth root of M. The Nth root of a number M is defined as a number X such that when X is raised to the power of N, it equals M. If the Nth root is not an integer, return -1.

Examples:
Input: N = 3, M = 27
Output: 3
Explanation: The cube root of 27 is equal to 3.

Input: N = 4, M = 69
Output:-1
Explanation: The 4th root of 69 does not exist. So, the answer is -1.
*/

class Solution {
  // Helper function to check mid^N compared to M
  helperFunc(mid, n, m) {
    let ans = 1,
      base = mid;

    while (n > 0) {
      if (n % 2 === 1) {
        ans *= base;
        if (ans > m) return 2; // Early exit
        n--;
      } else {
        n = Math.floor(n / 2);
        base *= base;
        if (base > m) return 2;
      }
    }
    if (ans === m) return 1;
    return 0;
  }

  // Function to find the Nth root of M using Binary Search
  NthRoot(N, M) {
    let low = 1,
      high = M;

    while (low <= high) {
      let mid = Math.floor((low + high) / 2);
      let midN = this.helperFunc(mid, N, M);

      if (midN === 1) return mid; // Found exact root
      else if (midN === 0) low = mid + 1; // Move right
      else high = mid - 1; // Move left
    }
    return -1; // No integer root found
  }
}
