/*
Find square root of a number
Given a positive integer n. Find and return its square root. If n is not a perfect square, then return the floor value of sqrt(n).

Examples:
Input: n = 36
Output: 6
Explanation: 6 is the square root of 36.

Input: n = 28
Output: 5
Explanation: The square root of 28 is approximately 5.292. So, the floor value will be 5.
*/

class Solution {
    public int floorSqrt(int n) {
        int low = 0;
        int high = (n >= 2) ? n / 2 : n;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Avoids integer overflow

            if (mid * mid <= n) {
                ans = mid;
                low = mid + 1; // Move right
            } else {
                high = mid - 1; // Move left
            }
        }

        return ans;
    }
}
