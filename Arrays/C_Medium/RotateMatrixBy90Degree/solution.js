/**
 * Given an N * N 2D integer matrix, rotate the matrix by 90 degrees clockwise.
 * The rotation must be done in place, meaning the input 2D matrix must be
 * modified directly.
 *
 * Example 1
 * Input: matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
 * Output: matrix = [[7, 4, 1], [8, 5, 2], [9, 6, 3]]
 *
 * Example 2
 * Input: matrix = [[0, 1, 1, 2], [2, 0, 3, 1], [4, 5, 0, 5], [5, 6, 7, 0]]
 * Output: matrix = [[5, 4, 2, 0], [6, 5, 0, 1], [7, 0, 3, 1], [0, 5, 1, 2]]
 *
 * Brute force:
 * rotated[j][n - i - 1] = matrix[i][j]: This is the core of the rotation logic.
 * It assigns the value of the current element (matrix[i][j]) to the
 * corresponding position in the rotated matrix.
 *
 * The key here is the index calculation:
 * j: The column index in the rotated matrix becomes the row index (i) in the
 * original matrix.
 * n - i - 1: The row index in the rotated matrix is calculated to achieve the
 * 90-degree clockwise rotation.
 *
 *
 *
 *
 * Optimal solution:
 * Transpose the matrix
 *
 * Input
 * [
 * [1, 2, 3],
 * [4, 5, 6],
 * [7, 8, 9]
 * ]
 * After Transpose
 * [
 * [1, 4, 7],
 * [2, 5, 8],
 * [3, 6, 9]
 * ]
 * After Reverse
 * [
 * [7, 4, 1],
 * [8, 5, 2],
 * [9, 6, 3]
 * ]
 */
class Solution {
  // Brute force
  rotateMatrix1(matrix) {
    let n = matrix.length;

    // Initialize new matrix to store rotated values
    let rotated = new Array(n).fill().map(() => new Array(n).fill(0));

    for (let i = 0; i < n; i++) {
      for (let j = 0; j < n; j++) {
        rotated[j][n - i - 1] = matrix[i][j];
      }
    }

    // Copy rotated elements back to original matrix
    for (let i = 0; i < n; i++) {
      for (let j = 0; j < n; j++) {
        matrix[i][j] = rotated[i][j];
      }
    }
  }

  // Optimal
  rotateMatrix2(matrix) {
    let n = matrix.length;

    // Transpose: This swaps elements across the main diagonal
    for (let i = 0; i < n; i++) {
      for (let j = 0; j < i; j++) {
        let temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }

    // Reverse each row of the matrix
    // This effectively rotates the transposed matrix 90 degrees clockwise
    for (let i = 0; i < n; i++) {
      for (let j = 0; j < Math.floor(n / 2); j++) {
        let temp = matrix[i][j];
        matrix[i][j] = matrix[i][n - 1 - j];
        matrix[i][n - 1 - j] = temp;
      }
    }
  }
}
