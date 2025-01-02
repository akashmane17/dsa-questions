/**
Pascal's Triangle

In Pascal's triangle:

    The first row has one element with a value of 1.
    Each row has one more element in it than its previous row.
    The value of each element is equal to the sum of the elements directly above it when arranged in a triangle format.

Example 1
Input: numRows = 4
Output: [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1]]
Explanation: 1st Row has its value set to 1.
All other cells take their value as the sum of the values directly above them

Example 2
Input: numRows = 5
Output: [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]
Explanation: 1st Row has its value set to 1.
All other cells take their value as the sum of the values directly above them


Solution: 
The code iterates through the number of rows specified by the numRows parameter.
In each iteration:

    prevRow: The previous row in the triangle is extracted from the ans array.
    currRow: An empty array is created to store the elements of the current row.
    The code iterates through the elements of the prevRow:
        First Element: The first element of the currRow is always 1.
        Last Element: The last element of the currRow is always 1.
        Middle Elements: Each middle element of the currRow is calculated by summing the corresponding element and its preceding element in the prevRow.
    The currRow is added to the ans array.

 */

class Solution {
  pascalTriangle(numRows) {
    let ans = [];
    ans.push([1]);

    for (let i = 1; i < numRows; i++) {
      let prevRow = ans[ans.length - 1];
      let currRow = [];

      for (let j = 0; j <= prevRow.length; j++) {
        // If its the first or last we'll add 1
        if (j === 0 || j === prevRow.length) {
          currRow.push(1);
        } else {
          // else we'll add 2 elements above it and store in array
          currRow.push(prevRow[j] + prevRow[j - 1]);
        }
      }
      ans.push(currRow);
    }

    return ans;
  }
}
