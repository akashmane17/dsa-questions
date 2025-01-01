/**
Print the matrix in spiral manner

Given an M * N matrix, print the elements in a clockwise spiral manner. Return an array with the elements in the order of their appearance when printed in a spiral manner.

Example 1
Input: matrix = [[1, 2, 3], [4 ,5 ,6], [7, 8, 9]]
Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]
Explanation: The elements in the spiral order are 1, 2, 3 -> 6, 9 -> 8, 7 -> 4, 5

Example 2
Input: matrix = [[1, 2, 3, 4], [5, 6, 7, 8]]
Output: [1, 2, 3, 4, 8, 7, 6, 5]
Explanation: The elements in the spiral order are 1, 2, 3, 4 -> 8, 7, 6, 5 


Initialization: top, bottom, left, right: Variables to keep track of the current boundaries of the spiral traversal. 
    Initially, they point to the outermost boundaries of the matrix.

Spiral Traversal:
    The while loop continues as long as there are still elements within the current boundaries of the spiral.
        Left to Right:
            Traverse the top row from left to right and add each element to the ans array.
            Move the top pointer downwards.
        Top to Bottom:
            Traverse the rightmost column from top to bottom and add each element to the ans array.
            Move the right pointer leftwards.
        Right to Left:
            If there are still rows to traverse (i.e., top is less than or equal to bottom), traverse the bottom row from right to left and add each element to the ans array.
            Move the bottom pointer upwards.
        Bottom to Top:
            If there are still columns to traverse (i.e., left is less than or equal to right), traverse the leftmost column from bottom to top and add each element to the ans array.
            Move the left pointer rightwards.
 */

class Solution {
  spiralOrder(matrix) {
    let ans = [];

    let n = matrix.length;
    let m = matrix[0].length;

    let top = 0;
    let bottom = n - 1;
    let left = 0;
    let right = m - 1;

    while (top <= bottom && left <= right) {
      // left to right
      for (let i = left; i <= right; i++) {
        ans.push(matrix[top][i]);
      }
      top++;

      // top to bottom
      for (let i = top; i <= bottom; i++) {
        ans.push(matrix[i][right]);
      }
      right--;

      // right to left
      if (top <= bottom) {
        for (let i = right; i >= left; i--) {
          ans.push(matrix[bottom][i]);
        }
        bottom--;
      }

      // bottom to top
      if (left <= right) {
        for (let i = bottom; i >= top; i--) {
          ans.push(matrix[i][left]);
        }
        left++;
      }
    }

    return ans;
  }
}
